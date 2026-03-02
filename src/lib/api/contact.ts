import type { ContactSubmission } from '../types';

/** Default contact email address for form submissions */
const CONTACT_EMAIL = 'sales@bluecross.tech';

/**
 * Response shape from contact form submission.
 */
export interface ContactResponse {
  success: boolean;
  message: string;
}

/**
 * Submits a contact form by opening the user's email client.
 * Validates required fields and email format before submission.
 * @param submission - Contact form data including name, email, subject, and message
 * @returns Response indicating success/failure with a user-friendly message
 */
export async function submitContactForm(
  submission: ContactSubmission
): Promise<ContactResponse> {
  // Validate input
  if (!submission.name || !submission.email || !submission.subject || !submission.message) {
    return {
      success: false,
      message: 'All fields are required.',
    };
  }

  // Email validation
  const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  if (!emailRegex.test(submission.email)) {
    return {
      success: false,
      message: 'Please enter a valid email address.',
    };
  }

  // Send directly via mailto - opens user's email client
  const mailtoLink = `mailto:${CONTACT_EMAIL}?subject=${encodeURIComponent(
    `[BlueCross Contact] ${submission.subject}`
  )}&body=${encodeURIComponent(
    `Name: ${submission.name}\nEmail: ${submission.email}\n\n${submission.message}`
  )}`;
  
  // Open email client
  window.location.href = mailtoLink;
  
  return {
    success: true,
    message: `Opening your email client to send directly to ${CONTACT_EMAIL}`,
  };
}
