/**
 * @fileoverview Privacy policy legal page.
 */
import { motion } from 'framer-motion';
import { Shield, Globe, Lock, Eye, UserCheck, Mail } from 'lucide-react';
import Container from '../components/Common/Container';

/**
 * Privacy policy page detailing data collection and usage practices.
 */
function PrivacyPolicy() {
  return (
    <main className="flex-1">
      {/* Hero */}
      <section className="pt-24 pb-12 md:pt-28 md:pb-16 bg-gradient-to-br from-brand-navy to-brand-blue">
        <Container>
          <motion.div
            initial={{ opacity: 0, y: 20 }}
            animate={{ opacity: 1, y: 0 }}
            className="text-center"
          >
            <div className="w-16 h-16 bg-white/10 rounded-full flex items-center justify-center mx-auto mb-6">
              <Shield className="w-8 h-8 text-white" />
            </div>
            <h1 className="text-3xl md:text-4xl font-bold text-white mb-4">
              Privacy Policy
            </h1>
            <p className="text-lg text-brand-sky-light max-w-2xl mx-auto">
              EU-US Data Privacy Framework Compliant
            </p>
            <p className="text-sm text-brand-sky-light/80 mt-2">
              Last Updated: November 2024
            </p>
          </motion.div>
        </Container>
      </section>

      {/* Content */}
      <section className="py-16 md:py-24">
        <Container>
          <div className="max-w-4xl mx-auto">
            {/* Introduction */}
            <motion.div
              initial={{ opacity: 0, y: 20 }}
              whileInView={{ opacity: 1, y: 0 }}
              viewport={{ once: true }}
              className="mb-12"
            >
              <div className="flex items-center gap-3 mb-4">
                <Globe className="w-6 h-6 text-brand-ocean" />
                <h2 className="text-2xl font-bold text-brand-navy">Introduction</h2>
              </div>
              <div className="prose prose-gray max-w-none">
                <p className="text-gray-600 mb-4">
                  BlueCross Medical ("BlueCross," "we," "us," or "our") is committed to protecting your privacy 
                  and ensuring the security of your personal data. This Privacy Policy explains how we collect, 
                  use, disclose, and safeguard your information when you visit our website, use our services, 
                  or purchase our products.
                </p>
                <p className="text-gray-600 mb-4">
                  We comply with the EU-US Data Privacy Framework (DPF), the UK Extension to the EU-US DPF, 
                  and the Swiss-US DPF as set forth by the U.S. Department of Commerce. We are committed to 
                  subjecting all personal data received from European Union (EU) member countries, the United 
                  Kingdom, and Switzerland in reliance on each Data Privacy Framework to the Framework's 
                  applicable principles.
                </p>
                <div className="bg-brand-ocean/5 border border-brand-ocean/20 rounded-lg p-4 mt-6">
                  <p className="text-sm text-brand-navy font-medium">
                    <strong>Data Controller:</strong> BlueCross Medical, registered in Greece (EU)
                  </p>
                  <p className="text-sm text-gray-600 mt-1">
                    Contact: bluecross@marsoft.ai
                  </p>
                </div>
              </div>
            </motion.div>

            {/* Data We Collect */}
            <motion.div
              initial={{ opacity: 0, y: 20 }}
              whileInView={{ opacity: 1, y: 0 }}
              viewport={{ once: true }}
              className="mb-12"
            >
              <div className="flex items-center gap-3 mb-4">
                <Eye className="w-6 h-6 text-brand-ocean" />
                <h2 className="text-2xl font-bold text-brand-navy">Information We Collect</h2>
              </div>
              <div className="space-y-6">
                <div className="bg-white border border-gray-200 rounded-xl p-6">
                  <h3 className="font-semibold text-brand-navy mb-3">Personal Information You Provide</h3>
                  <ul className="space-y-2 text-gray-600 text-sm">
                    <li className="flex items-start gap-2">
                      <span className="w-1.5 h-1.5 bg-brand-ocean rounded-full mt-2 flex-shrink-0"></span>
                      <span><strong>Contact Information:</strong> Name, email address, phone number, shipping address</span>
                    </li>
                    <li className="flex items-start gap-2">
                      <span className="w-1.5 h-1.5 bg-brand-ocean rounded-full mt-2 flex-shrink-0"></span>
                      <span><strong>Account Information:</strong> Username, password, account preferences</span>
                    </li>
                    <li className="flex items-start gap-2">
                      <span className="w-1.5 h-1.5 bg-brand-ocean rounded-full mt-2 flex-shrink-0"></span>
                      <span><strong>Transaction Information:</strong> Purchase history, payment details (processed securely by third-party providers)</span>
                    </li>
                    <li className="flex items-start gap-2">
                      <span className="w-1.5 h-1.5 bg-brand-ocean rounded-full mt-2 flex-shrink-0"></span>
                      <span><strong>Vessel Information:</strong> Vessel name, flag state, vessel type (for compliance purposes)</span>
                    </li>
                    <li className="flex items-start gap-2">
                      <span className="w-1.5 h-1.5 bg-brand-ocean rounded-full mt-2 flex-shrink-0"></span>
                      <span><strong>Communications:</strong> Inquiries, feedback, and correspondence with us</span>
                    </li>
                  </ul>
                </div>

                <div className="bg-white border border-gray-200 rounded-xl p-6">
                  <h3 className="font-semibold text-brand-navy mb-3">Information Collected Automatically</h3>
                  <ul className="space-y-2 text-gray-600 text-sm">
                    <li className="flex items-start gap-2">
                      <span className="w-1.5 h-1.5 bg-brand-ocean rounded-full mt-2 flex-shrink-0"></span>
                      <span><strong>Device Information:</strong> IP address, browser type, operating system</span>
                    </li>
                    <li className="flex items-start gap-2">
                      <span className="w-1.5 h-1.5 bg-brand-ocean rounded-full mt-2 flex-shrink-0"></span>
                      <span><strong>Usage Data:</strong> Pages visited, time spent, click patterns</span>
                    </li>
                    <li className="flex items-start gap-2">
                      <span className="w-1.5 h-1.5 bg-brand-ocean rounded-full mt-2 flex-shrink-0"></span>
                      <span><strong>Cookies:</strong> Essential and analytics cookies (see Cookie Policy below)</span>
                    </li>
                  </ul>
                </div>
              </div>
            </motion.div>

            {/* Legal Basis */}
            <motion.div
              initial={{ opacity: 0, y: 20 }}
              whileInView={{ opacity: 1, y: 0 }}
              viewport={{ once: true }}
              className="mb-12"
            >
              <div className="flex items-center gap-3 mb-4">
                <Lock className="w-6 h-6 text-brand-ocean" />
                <h2 className="text-2xl font-bold text-brand-navy">Legal Basis for Processing (GDPR)</h2>
              </div>
              <div className="grid md:grid-cols-2 gap-4">
                {[
                  {
                    title: 'Contract Performance',
                    description: 'Processing necessary to fulfill orders and provide services you requested.',
                  },
                  {
                    title: 'Legitimate Interests',
                    description: 'Improving our services, fraud prevention, and marketing (with opt-out).',
                  },
                  {
                    title: 'Legal Obligation',
                    description: 'Compliance with tax, accounting, and regulatory requirements.',
                  },
                  {
                    title: 'Consent',
                    description: 'Marketing communications and non-essential cookies (withdrawable anytime).',
                  },
                ].map((item, index) => (
                  <div key={index} className="bg-surface-secondary p-4 rounded-lg">
                    <h4 className="font-semibold text-brand-navy mb-1">{item.title}</h4>
                    <p className="text-sm text-gray-600">{item.description}</p>
                  </div>
                ))}
              </div>
            </motion.div>

            {/* Your Rights */}
            <motion.div
              initial={{ opacity: 0, y: 20 }}
              whileInView={{ opacity: 1, y: 0 }}
              viewport={{ once: true }}
              className="mb-12"
            >
              <div className="flex items-center gap-3 mb-4">
                <UserCheck className="w-6 h-6 text-brand-ocean" />
                <h2 className="text-2xl font-bold text-brand-navy">Your Rights Under GDPR & DPF</h2>
              </div>
              <div className="bg-white border border-gray-200 rounded-xl p-6">
                <p className="text-gray-600 mb-4">
                  Under the EU General Data Protection Regulation (GDPR) and the EU-US Data Privacy Framework, 
                  you have the following rights:
                </p>
                <div className="grid md:grid-cols-2 gap-4">
                  {[
                    { right: 'Right to Access', desc: 'Request a copy of your personal data' },
                    { right: 'Right to Rectification', desc: 'Correct inaccurate or incomplete data' },
                    { right: 'Right to Erasure', desc: 'Request deletion of your data ("right to be forgotten")' },
                    { right: 'Right to Restrict Processing', desc: 'Limit how we use your data' },
                    { right: 'Right to Data Portability', desc: 'Receive your data in a portable format' },
                    { right: 'Right to Object', desc: 'Object to processing based on legitimate interests' },
                    { right: 'Right to Withdraw Consent', desc: 'Withdraw consent at any time' },
                    { right: 'Right to Lodge Complaint', desc: 'File a complaint with a supervisory authority' },
                  ].map((item, index) => (
                    <div key={index} className="flex items-start gap-2">
                      <span className="w-1.5 h-1.5 bg-brand-ocean rounded-full mt-2 flex-shrink-0"></span>
                      <div>
                        <span className="font-medium text-brand-navy">{item.right}:</span>
                        <span className="text-sm text-gray-600 ml-1">{item.desc}</span>
                      </div>
                    </div>
                  ))}
                </div>
                <div className="mt-6 p-4 bg-brand-ocean/5 rounded-lg">
                  <p className="text-sm text-gray-600">
                    To exercise any of these rights, contact us at <a href="mailto:bluecross@marsoft.ai" className="text-brand-ocean hover:underline">bluecross@marsoft.ai</a>. 
                    We will respond within 30 days.
                  </p>
                </div>
              </div>
            </motion.div>

            {/* International Transfers */}
            <motion.div
              initial={{ opacity: 0, y: 20 }}
              whileInView={{ opacity: 1, y: 0 }}
              viewport={{ once: true }}
              className="mb-12"
            >
              <div className="flex items-center gap-3 mb-4">
                <Globe className="w-6 h-6 text-brand-ocean" />
                <h2 className="text-2xl font-bold text-brand-navy">International Data Transfers</h2>
              </div>
              <div className="prose prose-gray max-w-none">
                <p className="text-gray-600 mb-4">
                  As a Greek company, your data is primarily processed within the European Economic Area (EEA). 
                  When we transfer data outside the EEA, we ensure appropriate safeguards are in place:
                </p>
                <ul className="space-y-2 text-gray-600">
                  <li className="flex items-start gap-2">
                    <span className="w-1.5 h-1.5 bg-brand-ocean rounded-full mt-2 flex-shrink-0"></span>
                    <span><strong>EU-US Data Privacy Framework:</strong> For transfers to certified US organizations</span>
                  </li>
                  <li className="flex items-start gap-2">
                    <span className="w-1.5 h-1.5 bg-brand-ocean rounded-full mt-2 flex-shrink-0"></span>
                    <span><strong>Standard Contractual Clauses:</strong> EU-approved contractual safeguards</span>
                  </li>
                  <li className="flex items-start gap-2">
                    <span className="w-1.5 h-1.5 bg-brand-ocean rounded-full mt-2 flex-shrink-0"></span>
                    <span><strong>Adequacy Decisions:</strong> Transfers to countries with adequate protection levels</span>
                  </li>
                </ul>
              </div>
            </motion.div>

            {/* Data Retention */}
            <motion.div
              initial={{ opacity: 0, y: 20 }}
              whileInView={{ opacity: 1, y: 0 }}
              viewport={{ once: true }}
              className="mb-12"
            >
              <h2 className="text-2xl font-bold text-brand-navy mb-4">Data Retention</h2>
              <div className="bg-white border border-gray-200 rounded-xl p-6">
                <p className="text-gray-600 mb-4">
                  We retain your personal data only as long as necessary for the purposes outlined in this policy:
                </p>
                <div className="space-y-3">
                  {[
                    { type: 'Transaction Records', period: '7 years (legal/tax requirements)' },
                    { type: 'Account Information', period: 'Until account deletion + 30 days' },
                    { type: 'Marketing Preferences', period: 'Until consent withdrawal' },
                    { type: 'Analytics Data', period: '26 months (anonymized thereafter)' },
                  ].map((item, index) => (
                    <div key={index} className="flex justify-between items-center py-2 border-b border-gray-100 last:border-0">
                      <span className="text-gray-700">{item.type}</span>
                      <span className="text-sm text-brand-ocean font-medium">{item.period}</span>
                    </div>
                  ))}
                </div>
              </div>
            </motion.div>

            {/* Contact */}
            <motion.div
              initial={{ opacity: 0, y: 20 }}
              whileInView={{ opacity: 1, y: 0 }}
              viewport={{ once: true }}
              className="bg-brand-navy rounded-xl p-8 text-center"
            >
              <Mail className="w-10 h-10 text-brand-sky-light mx-auto mb-4" />
              <h2 className="text-xl font-bold text-white mb-2">Questions About Your Privacy?</h2>
              <p className="text-brand-sky-light mb-4">
                Contact us
              </p>
              <a
                href="mailto:bluecross@marsoft.ai"
                className="inline-flex items-center gap-2 bg-white text-brand-navy px-6 py-3 rounded-lg font-medium hover:bg-brand-sky-light transition-colors"
              >
                <Mail size={18} />
                bluecross@marsoft.ai
              </a>
              <p className="text-sm text-brand-sky-light/80 mt-4">
                EU Supervisory Authority: Hellenic Data Protection Authority (HDPA)
              </p>
            </motion.div>
          </div>
        </Container>
      </section>
    </main>
  );
}

export default PrivacyPolicy;
