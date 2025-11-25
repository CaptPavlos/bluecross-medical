import { useState } from 'react';
import { motion, AnimatePresence } from 'framer-motion';
import { Send, CheckCircle, AlertCircle } from 'lucide-react';
import FormInput from './FormInput';
import FormTextarea from './FormTextarea';
import Button from '../Common/Button';
import { submitContactForm } from '../../lib/api/contact';
import { isValidEmail } from '../../lib/utils';
import type { ContactSubmission } from '../../lib/types';

interface FormErrors {
  name?: string;
  email?: string;
  subject?: string;
  message?: string;
}

function ContactForm() {
  const [formData, setFormData] = useState<ContactSubmission>({
    name: '',
    email: '',
    subject: '',
    message: '',
  });
  const [errors, setErrors] = useState<FormErrors>({});
  const [isSubmitting, setIsSubmitting] = useState(false);
  const [submitStatus, setSubmitStatus] = useState<'idle' | 'success' | 'error'>('idle');
  const [statusMessage, setStatusMessage] = useState('');

  const validateForm = (): boolean => {
    const newErrors: FormErrors = {};

    if (!formData.name.trim()) {
      newErrors.name = 'Name is required';
    }

    if (!formData.email.trim()) {
      newErrors.email = 'Email is required';
    } else if (!isValidEmail(formData.email)) {
      newErrors.email = 'Please enter a valid email address';
    }

    if (!formData.subject.trim()) {
      newErrors.subject = 'Subject is required';
    }

    if (!formData.message.trim()) {
      newErrors.message = 'Message is required';
    } else if (formData.message.length < 10) {
      newErrors.message = 'Message must be at least 10 characters';
    }

    setErrors(newErrors);
    return Object.keys(newErrors).length === 0;
  };

  const handleChange = (
    e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>
  ) => {
    const { name, value } = e.target;
    setFormData((prev) => ({ ...prev, [name]: value }));
    // Clear error when user types
    if (errors[name as keyof FormErrors]) {
      setErrors((prev) => ({ ...prev, [name]: undefined }));
    }
  };

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();

    if (!validateForm()) return;

    setIsSubmitting(true);
    setSubmitStatus('idle');

    try {
      const response = await submitContactForm(formData);
      
      if (response.success) {
        setSubmitStatus('success');
        setStatusMessage(response.message);
        setFormData({ name: '', email: '', subject: '', message: '' });
      } else {
        setSubmitStatus('error');
        setStatusMessage(response.message);
      }
    } catch {
      setSubmitStatus('error');
      setStatusMessage('An unexpected error occurred. Please try again.');
    } finally {
      setIsSubmitting(false);
    }
  };

  return (
    <form onSubmit={handleSubmit} className="space-y-6">
      <div className="grid md:grid-cols-2 gap-4">
        <FormInput
          name="name"
          label="Name"
          placeholder="John Doe"
          value={formData.name}
          onChange={handleChange}
          error={errors.name}
          required
        />
        <FormInput
          name="email"
          type="email"
          label="Email"
          placeholder="john@example.com"
          value={formData.email}
          onChange={handleChange}
          error={errors.email}
          required
        />
      </div>

      <FormInput
        name="subject"
        label="Subject"
        placeholder="How can we help?"
        value={formData.subject}
        onChange={handleChange}
        error={errors.subject}
        required
      />

      <FormTextarea
        name="message"
        label="Message"
        placeholder="Tell us more about your inquiry..."
        value={formData.message}
        onChange={handleChange}
        error={errors.message}
        rows={5}
        required
      />

      <AnimatePresence>
        {submitStatus !== 'idle' && (
          <motion.div
            initial={{ opacity: 0, y: -10 }}
            animate={{ opacity: 1, y: 0 }}
            exit={{ opacity: 0, y: -10 }}
            className={`flex items-center gap-2 p-4 rounded-lg ${
              submitStatus === 'success'
                ? 'bg-brand-green/10 text-brand-green'
                : 'bg-brand-red/10 text-brand-red'
            }`}
          >
            {submitStatus === 'success' ? (
              <CheckCircle size={20} />
            ) : (
              <AlertCircle size={20} />
            )}
            <span>{statusMessage}</span>
          </motion.div>
        )}
      </AnimatePresence>

      <Button
        type="submit"
        size="lg"
        isLoading={isSubmitting}
        rightIcon={<Send size={18} />}
        className="w-full md:w-auto"
      >
        Send Message
      </Button>
    </form>
  );
}

export default ContactForm;
