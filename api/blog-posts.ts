import type { VercelRequest, VercelResponse } from '@vercel/node';
import { neon } from '@neondatabase/serverless';

/**
 * API endpoint to fetch blog posts from the database
 * GET /api/blog-posts - Returns all published blog posts
 * GET /api/blog-posts?slug=xxx - Returns a single blog post by slug
 */
export default async function handler(req: VercelRequest, res: VercelResponse) {
  // Set CORS headers
  res.setHeader('Access-Control-Allow-Origin', '*');
  res.setHeader('Access-Control-Allow-Methods', 'GET, OPTIONS');
  res.setHeader('Access-Control-Allow-Headers', 'Content-Type');

  // Handle preflight
  if (req.method === 'OPTIONS') {
    return res.status(200).end();
  }

  // Only allow GET
  if (req.method !== 'GET') {
    return res.status(405).json({ error: 'Method not allowed' });
  }

  // Get database URL
  const databaseUrl = process.env.NEON_DATABASE_URL || process.env.VITE_NEON_DATABASE_URL;
  if (!databaseUrl) {
    console.error('Database URL not configured');
    return res.status(500).json({ error: 'Database not configured' });
  }

  try {
    const sql = neon(databaseUrl);
    const { slug } = req.query;

    if (slug && typeof slug === 'string') {
      // Fetch single post by slug
      const posts = await sql`
        SELECT * FROM blog_posts 
        WHERE slug = ${slug} AND published = true
        LIMIT 1
      `;
      
      if (posts.length === 0) {
        return res.status(404).json({ error: 'Post not found' });
      }
      
      return res.status(200).json(posts[0]);
    } else {
      // Fetch all published posts
      const posts = await sql`
        SELECT * FROM blog_posts 
        WHERE published = true
        ORDER BY published_at DESC
      `;
      
      return res.status(200).json(posts);
    }
  } catch (error) {
    console.error('Error fetching blog posts:', error);
    return res.status(500).json({ 
      error: 'Failed to fetch blog posts',
      details: error instanceof Error ? error.message : 'Unknown error'
    });
  }
}
