import { useState, useEffect } from 'react';
import { motion } from 'framer-motion';
import { RefreshCw, Check, X, FileText, Clock, AlertCircle, ExternalLink, Webhook } from 'lucide-react';
import Container from '../../components/Common/Container';
import Card from '../../components/Common/Card';
import Badge from '../../components/Common/Badge';
import {
  fetchAllArticles,
  fetchArticleById,
  publishArticle,
  syncArticles,
  isBabyLoveGrowthConfigured,
  type BabyLoveGrowthArticleListItem,
} from '../../lib/api/babylovegrowth';
import type { BlogPost } from '../../lib/types';

function BabyLoveGrowthSync() {
  const [isConfigured, setIsConfigured] = useState(false);
  const [articles, setArticles] = useState<BabyLoveGrowthArticleListItem[]>([]);
  const [isLoading, setIsLoading] = useState(false);
  const [isSyncing, setIsSyncing] = useState(false);
  const [syncResults, setSyncResults] = useState<{ published: number; failed: number; articles: BlogPost[] } | null>(null);
  const [error, setError] = useState<string | null>(null);
  const [publishingId, setPublishingId] = useState<number | null>(null);

  // Get webhook URL for display
  const webhookUrl = typeof window !== 'undefined' 
    ? `${window.location.origin}/api/babylovegrowth-webhook`
    : '/api/babylovegrowth-webhook';

  useEffect(() => {
    setIsConfigured(isBabyLoveGrowthConfigured());
  }, []);

  const handleFetchArticles = async () => {
    setIsLoading(true);
    setError(null);
    try {
      const fetchedArticles = await fetchAllArticles();
      setArticles(fetchedArticles);
    } catch (err) {
      setError(err instanceof Error ? err.message : 'Failed to fetch articles');
    } finally {
      setIsLoading(false);
    }
  };

  const handleSyncAll = async () => {
    setIsSyncing(true);
    setError(null);
    setSyncResults(null);
    try {
      const results = await syncArticles();
      setSyncResults(results);
      // Refresh article list
      await handleFetchArticles();
    } catch (err) {
      setError(err instanceof Error ? err.message : 'Sync failed');
    } finally {
      setIsSyncing(false);
    }
  };

  const handlePublishSingle = async (articleItem: BabyLoveGrowthArticleListItem) => {
    setPublishingId(articleItem.id);
    setError(null);
    try {
      const fullArticle = await fetchArticleById(articleItem.id);
      if (fullArticle) {
        await publishArticle(fullArticle);
        // Remove from list
        setArticles(prev => prev.filter(a => a.id !== articleItem.id));
      }
    } catch (err) {
      setError(err instanceof Error ? err.message : 'Failed to publish article');
    } finally {
      setPublishingId(null);
    }
  };

  if (!isConfigured) {
    return (
      <main className="flex-1 pt-24">
        <Container size="md">
          <div className="py-12 space-y-6">
            {/* API Key Setup */}
            <Card className="text-center py-12">
              <AlertCircle size={48} className="mx-auto text-amber-500 mb-4" />
              <h1 className="text-h1 font-bold text-brand-slate mb-4">
                BabyLoveGrowth API Not Configured
              </h1>
              <p className="text-brand-gray mb-6 max-w-md mx-auto">
                To manually fetch articles, add your API key:
              </p>
              <div className="bg-gray-100 rounded-lg p-4 text-left max-w-md mx-auto font-mono text-sm">
                <p>VITE_BABYLOVEGROWTH_API_KEY=your-api-key</p>
              </div>
              <p className="text-brand-gray mt-6 text-sm">
                Get your API key from{' '}
                <a
                  href="https://www.babylovegrowth.ai"
                  target="_blank"
                  rel="noopener noreferrer"
                  className="text-brand-ocean hover:underline inline-flex items-center gap-1"
                >
                  Dashboard → Settings → Integrations <ExternalLink size={14} />
                </a>
              </p>
            </Card>

            {/* Webhook Setup (always show) */}
            <Card className="py-8 px-6">
              <div className="flex items-start gap-4">
                <Webhook size={32} className="text-brand-ocean flex-shrink-0 mt-1" />
                <div>
                  <h2 className="text-h2 font-bold text-brand-slate mb-2">
                    Automatic Publishing via Webhook
                  </h2>
                  <p className="text-brand-gray mb-4">
                    For automatic publishing when you click "Publish Now" in BabyLoveGrowth, configure the webhook:
                  </p>
                  <div className="space-y-3">
                    <div>
                      <p className="text-sm font-medium text-brand-slate mb-1">Webhook URL:</p>
                      <code className="block bg-gray-100 rounded px-3 py-2 text-sm break-all">
                        {webhookUrl}
                      </code>
                    </div>
                    <div>
                      <p className="text-sm font-medium text-brand-slate mb-1">Environment Variables (Vercel):</p>
                      <div className="bg-gray-100 rounded-lg p-3 font-mono text-sm space-y-1">
                        <p>BABYLOVEGROWTH_WEBHOOK_SECRET=your-secret</p>
                        <p>NEON_DATABASE_URL=your-database-url</p>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </Card>
          </div>
        </Container>
      </main>
    );
  }

  return (
    <main className="flex-1">
      {/* Header */}
      <section className="pt-24 pb-8 md:pt-28 bg-gradient-to-br from-brand-navy to-brand-blue">
        <Container>
          <motion.div
            initial={{ opacity: 0, y: 20 }}
            animate={{ opacity: 1, y: 0 }}
            className="text-center"
          >
            <h1 className="text-display md:text-5xl font-bold text-white mb-4">
              BabyLoveGrowth Sync
            </h1>
            <p className="text-lg text-brand-sky-light max-w-2xl mx-auto">
              Fetch and publish AI-generated articles from BabyLoveGrowth
            </p>
          </motion.div>
        </Container>
      </section>

      {/* Webhook Info */}
      <section className="py-6 bg-blue-50 border-b border-blue-100">
        <Container>
          <div className="flex items-center gap-3">
            <Webhook size={20} className="text-brand-ocean" />
            <div className="flex-1">
              <p className="text-sm text-brand-slate">
                <strong>Webhook URL:</strong>{' '}
                <code className="bg-white px-2 py-0.5 rounded text-xs">{webhookUrl}</code>
              </p>
            </div>
          </div>
        </Container>
      </section>

      {/* Actions */}
      <section className="py-8 border-b border-gray-100">
        <Container>
          <div className="flex flex-wrap gap-4 justify-center">
            <button
              onClick={handleFetchArticles}
              disabled={isLoading}
              className="inline-flex items-center gap-2 px-6 py-3 bg-white border border-gray-200 rounded-lg hover:bg-gray-50 transition-colors disabled:opacity-50"
            >
              <RefreshCw size={18} className={isLoading ? 'animate-spin' : ''} />
              {isLoading ? 'Fetching...' : 'Fetch All Articles'}
            </button>
            <button
              onClick={handleSyncAll}
              disabled={isSyncing || articles.length === 0}
              className="inline-flex items-center gap-2 px-6 py-3 bg-brand-ocean text-white rounded-lg hover:bg-brand-ocean-light transition-colors disabled:opacity-50"
            >
              <Check size={18} />
              {isSyncing ? 'Syncing...' : `Publish All (${articles.length})`}
            </button>
          </div>
        </Container>
      </section>

      {/* Error Message */}
      {error && (
        <section className="py-4">
          <Container>
            <div className="bg-red-50 border border-red-200 rounded-lg p-4 flex items-center gap-3">
              <X size={20} className="text-red-500" />
              <p className="text-red-700">{error}</p>
            </div>
          </Container>
        </section>
      )}

      {/* Sync Results */}
      {syncResults && (
        <section className="py-4">
          <Container>
            <div className="bg-green-50 border border-green-200 rounded-lg p-4">
              <div className="flex items-center gap-3 mb-2">
                <Check size={20} className="text-green-500" />
                <p className="text-green-700 font-medium">
                  Sync Complete: {syncResults.published} published, {syncResults.failed} failed
                </p>
              </div>
              {syncResults.articles.length > 0 && (
                <ul className="ml-8 text-sm text-green-600">
                  {syncResults.articles.map(article => (
                    <li key={article.id}>✓ {article.title}</li>
                  ))}
                </ul>
              )}
            </div>
          </Container>
        </section>
      )}

      {/* Articles List */}
      <section className="py-8">
        <Container>
          {articles.length === 0 ? (
            <Card className="text-center py-12">
              <FileText size={48} className="mx-auto text-brand-gray mb-4" />
              <h2 className="text-h2 font-semibold text-brand-slate mb-2">
                No Articles Found
              </h2>
              <p className="text-brand-gray">
                Click "Fetch All Articles" to load content from BabyLoveGrowth
              </p>
            </Card>
          ) : (
            <div className="space-y-4">
              <h2 className="text-h2 font-semibold text-brand-slate">
                Available Articles ({articles.length})
              </h2>
              {articles.map((article) => (
                <Card key={article.id} className="p-6">
                  <div className="flex flex-col md:flex-row md:items-center gap-4">
                    {/* Content */}
                    <div className="flex-1">
                      <div className="flex flex-wrap gap-2 mb-2">
                        <Badge variant="info" size="sm">
                          {article.languageCode.toUpperCase()}
                        </Badge>
                        {article.keywords?.slice(0, 3).map(keyword => (
                          <Badge key={keyword} variant="default" size="sm">
                            {keyword}
                          </Badge>
                        ))}
                      </div>
                      <h3 className="text-h3 font-semibold text-brand-slate mb-1">
                        {article.title}
                      </h3>
                      <p className="text-brand-gray text-sm">
                        Seed keyword: {article.seedKeyword}
                      </p>
                      <p className="text-brand-gray text-xs mt-2 flex items-center gap-1">
                        <Clock size={12} />
                        {new Date(article.created_at).toLocaleDateString()}
                      </p>
                    </div>

                    {/* Actions */}
                    <div className="flex gap-2">
                      <button
                        onClick={() => handlePublishSingle(article)}
                        disabled={publishingId === article.id}
                        className="inline-flex items-center gap-2 px-4 py-2 bg-brand-ocean text-white rounded-lg hover:bg-brand-ocean-light transition-colors disabled:opacity-50"
                      >
                        {publishingId === article.id ? (
                          <>
                            <RefreshCw size={16} className="animate-spin" />
                            Publishing...
                          </>
                        ) : (
                          <>
                            <Check size={16} />
                            Publish
                          </>
                        )}
                      </button>
                    </div>
                  </div>
                </Card>
              ))}
            </div>
          )}
        </Container>
      </section>
    </main>
  );
}

export default BabyLoveGrowthSync;
