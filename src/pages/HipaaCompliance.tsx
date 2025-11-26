import { motion } from 'framer-motion';
import { ShieldCheck, Database, Lock, Server, FileCheck, AlertCircle, Mail, ExternalLink } from 'lucide-react';
import Container from '../components/Common/Container';

function HipaaCompliance() {
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
              <ShieldCheck className="w-8 h-8 text-white" />
            </div>
            <h1 className="text-3xl md:text-4xl font-bold text-white mb-4">
              HIPAA Compliance Notice
            </h1>
            <p className="text-lg text-brand-sky-light max-w-2xl mx-auto">
              Medical Equipment Data Handling & Third-Party Software
            </p>
            <p className="text-sm text-brand-sky-light/80 mt-2">
              Last Updated: November 2024
            </p>
          </motion.div>
        </Container>
      </section>

      {/* Scope Notice */}
      <section className="py-8 bg-amber-50 border-b border-amber-200">
        <Container>
          <div className="flex items-start gap-4 max-w-4xl mx-auto">
            <AlertCircle className="w-6 h-6 text-amber-600 flex-shrink-0 mt-1" />
            <div>
              <h2 className="font-semibold text-amber-800 mb-1">Important Scope Clarification</h2>
              <p className="text-sm text-amber-700">
                BlueCross Medical is a Greek company and is not directly subject to HIPAA regulations. 
                This notice applies specifically to medical equipment we sell that generates, stores, or transmits 
                Protected Health Information (PHI) through integrated software systems. The HIPAA-compliant handling 
                of such data is managed by the respective software providers, not by BlueCross directly.
              </p>
            </div>
          </div>
        </Container>
      </section>

      {/* Content */}
      <section className="py-16 md:py-24">
        <Container>
          <div className="max-w-4xl mx-auto">
            {/* Overview */}
            <motion.div
              initial={{ opacity: 0, y: 20 }}
              whileInView={{ opacity: 1, y: 0 }}
              viewport={{ once: true }}
              className="mb-12"
            >
              <div className="flex items-center gap-3 mb-4">
                <Database className="w-6 h-6 text-brand-ocean" />
                <h2 className="text-2xl font-bold text-brand-navy">1. Overview</h2>
              </div>
              <div className="prose prose-gray max-w-none">
                <p className="text-gray-600 mb-4">
                  Certain medical equipment sold by BlueCross Medical includes software components that may 
                  process Protected Health Information (PHI) as defined under the Health Insurance Portability 
                  and Accountability Act (HIPAA). This includes, but is not limited to:
                </p>
                <ul className="space-y-2 text-gray-600">
                  <li className="flex items-start gap-2">
                    <span className="w-1.5 h-1.5 bg-brand-ocean rounded-full mt-2 flex-shrink-0"></span>
                    <span>Patient monitoring devices with data logging capabilities</span>
                  </li>
                  <li className="flex items-start gap-2">
                    <span className="w-1.5 h-1.5 bg-brand-ocean rounded-full mt-2 flex-shrink-0"></span>
                    <span>Diagnostic equipment that stores patient information</span>
                  </li>
                  <li className="flex items-start gap-2">
                    <span className="w-1.5 h-1.5 bg-brand-ocean rounded-full mt-2 flex-shrink-0"></span>
                    <span>Telemedicine devices that transmit medical data</span>
                  </li>
                  <li className="flex items-start gap-2">
                    <span className="w-1.5 h-1.5 bg-brand-ocean rounded-full mt-2 flex-shrink-0"></span>
                    <span>Electronic medical record interfaces on medical devices</span>
                  </li>
                </ul>
              </div>
            </motion.div>

            {/* Third-Party Software */}
            <motion.div
              initial={{ opacity: 0, y: 20 }}
              whileInView={{ opacity: 1, y: 0 }}
              viewport={{ once: true }}
              className="mb-12"
            >
              <div className="flex items-center gap-3 mb-4">
                <Server className="w-6 h-6 text-brand-ocean" />
                <h2 className="text-2xl font-bold text-brand-navy">2. HIPAA-Compliant Software Partners</h2>
              </div>
              
              <div className="bg-white border border-gray-200 rounded-xl p-6 mb-6">
                <p className="text-gray-600 mb-4">
                  When medical equipment we sell includes software that handles PHI, that software is provided 
                  by third-party vendors who maintain their own HIPAA compliance programs. These vendors:
                </p>
                <div className="grid md:grid-cols-2 gap-4">
                  {[
                    {
                      icon: ShieldCheck,
                      title: 'BAA Availability',
                      description: 'Offer Business Associate Agreements (BAAs) to covered entities',
                    },
                    {
                      icon: Lock,
                      title: 'Security Measures',
                      description: 'Implement required administrative, physical, and technical safeguards',
                    },
                    {
                      icon: FileCheck,
                      title: 'Compliance Audits',
                      description: 'Undergo regular third-party security assessments and audits',
                    },
                    {
                      icon: Database,
                      title: 'Data Handling',
                      description: 'Maintain policies for PHI storage, transmission, and disposal',
                    },
                  ].map((item, index) => (
                    <div key={index} className="flex items-start gap-3 p-4 bg-surface-secondary rounded-lg">
                      <item.icon className="w-5 h-5 text-brand-ocean flex-shrink-0 mt-0.5" />
                      <div>
                        <h4 className="font-medium text-brand-navy text-sm">{item.title}</h4>
                        <p className="text-xs text-gray-600 mt-1">{item.description}</p>
                      </div>
                    </div>
                  ))}
                </div>
              </div>

              <div className="bg-brand-ocean/5 border border-brand-ocean/20 rounded-lg p-4">
                <p className="text-sm text-brand-navy">
                  <strong>Note:</strong> Customers who are HIPAA-covered entities must execute Business Associate 
                  Agreements directly with the software providers. BlueCross can facilitate introductions but is 
                  not a party to these agreements.
                </p>
              </div>
            </motion.div>

            {/* Types of PHI */}
            <motion.div
              initial={{ opacity: 0, y: 20 }}
              whileInView={{ opacity: 1, y: 0 }}
              viewport={{ once: true }}
              className="mb-12"
            >
              <div className="flex items-center gap-3 mb-4">
                <FileCheck className="w-6 h-6 text-brand-ocean" />
                <h2 className="text-2xl font-bold text-brand-navy">3. Protected Health Information Scope</h2>
              </div>
              
              <div className="bg-white border border-gray-200 rounded-xl p-6">
                <p className="text-gray-600 mb-4">
                  The following types of data may be processed by equipment software and are subject to 
                  HIPAA protections when handled by compliant software:
                </p>
                <div className="grid md:grid-cols-2 gap-6">
                  <div>
                    <h4 className="font-semibold text-brand-navy mb-3">Patient Identifiers</h4>
                    <ul className="space-y-2 text-gray-600 text-sm">
                      <li className="flex items-start gap-2">
                        <span className="w-1.5 h-1.5 bg-brand-ocean rounded-full mt-2 flex-shrink-0"></span>
                        <span>Names and demographic information</span>
                      </li>
                      <li className="flex items-start gap-2">
                        <span className="w-1.5 h-1.5 bg-brand-ocean rounded-full mt-2 flex-shrink-0"></span>
                        <span>Dates (birth, treatment, admission)</span>
                      </li>
                      <li className="flex items-start gap-2">
                        <span className="w-1.5 h-1.5 bg-brand-ocean rounded-full mt-2 flex-shrink-0"></span>
                        <span>Contact information</span>
                      </li>
                      <li className="flex items-start gap-2">
                        <span className="w-1.5 h-1.5 bg-brand-ocean rounded-full mt-2 flex-shrink-0"></span>
                        <span>Medical record numbers</span>
                      </li>
                    </ul>
                  </div>
                  <div>
                    <h4 className="font-semibold text-brand-navy mb-3">Clinical Data</h4>
                    <ul className="space-y-2 text-gray-600 text-sm">
                      <li className="flex items-start gap-2">
                        <span className="w-1.5 h-1.5 bg-brand-ocean rounded-full mt-2 flex-shrink-0"></span>
                        <span>Vital signs and monitoring data</span>
                      </li>
                      <li className="flex items-start gap-2">
                        <span className="w-1.5 h-1.5 bg-brand-ocean rounded-full mt-2 flex-shrink-0"></span>
                        <span>Diagnostic results</span>
                      </li>
                      <li className="flex items-start gap-2">
                        <span className="w-1.5 h-1.5 bg-brand-ocean rounded-full mt-2 flex-shrink-0"></span>
                        <span>Treatment records</span>
                      </li>
                      <li className="flex items-start gap-2">
                        <span className="w-1.5 h-1.5 bg-brand-ocean rounded-full mt-2 flex-shrink-0"></span>
                        <span>Medication administration logs</span>
                      </li>
                    </ul>
                  </div>
                </div>
              </div>
            </motion.div>

            {/* Security Standards */}
            <motion.div
              initial={{ opacity: 0, y: 20 }}
              whileInView={{ opacity: 1, y: 0 }}
              viewport={{ once: true }}
              className="mb-12"
            >
              <div className="flex items-center gap-3 mb-4">
                <Lock className="w-6 h-6 text-brand-ocean" />
                <h2 className="text-2xl font-bold text-brand-navy">4. Security Standards</h2>
              </div>
              
              <p className="text-gray-600 mb-6">
                HIPAA-compliant software integrated with our medical equipment adheres to the following 
                security requirements:
              </p>

              <div className="space-y-4">
                <div className="bg-white border border-gray-200 rounded-xl p-6">
                  <h3 className="font-semibold text-brand-navy mb-3">Technical Safeguards</h3>
                  <div className="grid md:grid-cols-2 gap-4">
                    {[
                      'AES-256 encryption for data at rest',
                      'TLS 1.2+ encryption for data in transit',
                      'Multi-factor authentication (MFA)',
                      'Role-based access controls (RBAC)',
                      'Automatic session timeouts',
                      'Audit logging and monitoring',
                      'Secure backup and recovery',
                      'Intrusion detection systems',
                    ].map((item, index) => (
                      <div key={index} className="flex items-center gap-2 text-sm text-gray-600">
                        <ShieldCheck className="w-4 h-4 text-green-600 flex-shrink-0" />
                        <span>{item}</span>
                      </div>
                    ))}
                  </div>
                </div>

                <div className="bg-white border border-gray-200 rounded-xl p-6">
                  <h3 className="font-semibold text-brand-navy mb-3">Administrative Safeguards</h3>
                  <ul className="space-y-2 text-gray-600 text-sm">
                    <li className="flex items-start gap-2">
                      <span className="w-1.5 h-1.5 bg-brand-ocean rounded-full mt-2 flex-shrink-0"></span>
                      <span>Designated security officers and privacy officers</span>
                    </li>
                    <li className="flex items-start gap-2">
                      <span className="w-1.5 h-1.5 bg-brand-ocean rounded-full mt-2 flex-shrink-0"></span>
                      <span>Workforce training and security awareness programs</span>
                    </li>
                    <li className="flex items-start gap-2">
                      <span className="w-1.5 h-1.5 bg-brand-ocean rounded-full mt-2 flex-shrink-0"></span>
                      <span>Incident response and breach notification procedures</span>
                    </li>
                    <li className="flex items-start gap-2">
                      <span className="w-1.5 h-1.5 bg-brand-ocean rounded-full mt-2 flex-shrink-0"></span>
                      <span>Regular risk assessments and policy reviews</span>
                    </li>
                  </ul>
                </div>

                <div className="bg-white border border-gray-200 rounded-xl p-6">
                  <h3 className="font-semibold text-brand-navy mb-3">Physical Safeguards</h3>
                  <ul className="space-y-2 text-gray-600 text-sm">
                    <li className="flex items-start gap-2">
                      <span className="w-1.5 h-1.5 bg-brand-ocean rounded-full mt-2 flex-shrink-0"></span>
                      <span>SOC 2 Type II certified data centers</span>
                    </li>
                    <li className="flex items-start gap-2">
                      <span className="w-1.5 h-1.5 bg-brand-ocean rounded-full mt-2 flex-shrink-0"></span>
                      <span>Facility access controls and monitoring</span>
                    </li>
                    <li className="flex items-start gap-2">
                      <span className="w-1.5 h-1.5 bg-brand-ocean rounded-full mt-2 flex-shrink-0"></span>
                      <span>Secure workstation and device policies</span>
                    </li>
                    <li className="flex items-start gap-2">
                      <span className="w-1.5 h-1.5 bg-brand-ocean rounded-full mt-2 flex-shrink-0"></span>
                      <span>Media disposal and sanitization procedures</span>
                    </li>
                  </ul>
                </div>
              </div>
            </motion.div>

            {/* Customer Responsibilities */}
            <motion.div
              initial={{ opacity: 0, y: 20 }}
              whileInView={{ opacity: 1, y: 0 }}
              viewport={{ once: true }}
              className="mb-12"
            >
              <div className="flex items-center gap-3 mb-4">
                <AlertCircle className="w-6 h-6 text-brand-ocean" />
                <h2 className="text-2xl font-bold text-brand-navy">5. Customer Responsibilities</h2>
              </div>
              
              <div className="bg-amber-50 border border-amber-200 rounded-xl p-6">
                <p className="text-amber-800 mb-4">
                  If you are a HIPAA-covered entity or business associate, you are responsible for:
                </p>
                <ul className="space-y-3 text-amber-800 text-sm">
                  <li className="flex items-start gap-2">
                    <span className="w-1.5 h-1.5 bg-amber-600 rounded-full mt-2 flex-shrink-0"></span>
                    <span><strong>BAA Execution:</strong> Entering into Business Associate Agreements with software providers before using equipment that processes PHI</span>
                  </li>
                  <li className="flex items-start gap-2">
                    <span className="w-1.5 h-1.5 bg-amber-600 rounded-full mt-2 flex-shrink-0"></span>
                    <span><strong>Access Management:</strong> Properly configuring user access and permissions on devices</span>
                  </li>
                  <li className="flex items-start gap-2">
                    <span className="w-1.5 h-1.5 bg-amber-600 rounded-full mt-2 flex-shrink-0"></span>
                    <span><strong>Training:</strong> Ensuring staff are trained on HIPAA requirements and device operation</span>
                  </li>
                  <li className="flex items-start gap-2">
                    <span className="w-1.5 h-1.5 bg-amber-600 rounded-full mt-2 flex-shrink-0"></span>
                    <span><strong>Physical Security:</strong> Securing devices and preventing unauthorized physical access</span>
                  </li>
                  <li className="flex items-start gap-2">
                    <span className="w-1.5 h-1.5 bg-amber-600 rounded-full mt-2 flex-shrink-0"></span>
                    <span><strong>Incident Reporting:</strong> Reporting any suspected breaches to the software provider immediately</span>
                  </li>
                  <li className="flex items-start gap-2">
                    <span className="w-1.5 h-1.5 bg-amber-600 rounded-full mt-2 flex-shrink-0"></span>
                    <span><strong>Decommissioning:</strong> Properly wiping PHI from devices before disposal or return</span>
                  </li>
                </ul>
              </div>
            </motion.div>

            {/* BlueCross Role */}
            <motion.div
              initial={{ opacity: 0, y: 20 }}
              whileInView={{ opacity: 1, y: 0 }}
              viewport={{ once: true }}
              className="mb-12"
            >
              <h2 className="text-2xl font-bold text-brand-navy mb-4">6. BlueCross Medical's Role</h2>
              
              <div className="bg-white border border-gray-200 rounded-xl p-6">
                <p className="text-gray-600 mb-4">
                  As an equipment reseller, BlueCross Medical:
                </p>
                <div className="space-y-4">
                  <div className="flex items-start gap-3 p-4 bg-green-50 rounded-lg">
                    <ShieldCheck className="w-5 h-5 text-green-600 flex-shrink-0 mt-0.5" />
                    <div>
                      <h4 className="font-medium text-green-800 text-sm">What We Do</h4>
                      <ul className="text-xs text-green-700 mt-2 space-y-1">
                        <li>• Verify that equipment software providers maintain HIPAA compliance programs</li>
                        <li>• Provide documentation about software compliance capabilities</li>
                        <li>• Facilitate connections between customers and software providers for BAAs</li>
                        <li>• Include compliance information in product documentation</li>
                      </ul>
                    </div>
                  </div>
                  
                  <div className="flex items-start gap-3 p-4 bg-gray-50 rounded-lg">
                    <AlertCircle className="w-5 h-5 text-gray-600 flex-shrink-0 mt-0.5" />
                    <div>
                      <h4 className="font-medium text-gray-800 text-sm">What We Don't Do</h4>
                      <ul className="text-xs text-gray-600 mt-2 space-y-1">
                        <li>• Process, store, or transmit PHI ourselves</li>
                        <li>• Act as a Business Associate under HIPAA</li>
                        <li>• Provide HIPAA compliance consulting or legal advice</li>
                        <li>• Guarantee compliance of third-party software</li>
                      </ul>
                    </div>
                  </div>
                </div>
              </div>
            </motion.div>

            {/* Resources */}
            <motion.div
              initial={{ opacity: 0, y: 20 }}
              whileInView={{ opacity: 1, y: 0 }}
              viewport={{ once: true }}
              className="mb-12"
            >
              <h2 className="text-2xl font-bold text-brand-navy mb-4">7. Additional Resources</h2>
              
              <div className="grid md:grid-cols-2 gap-4">
                {[
                  {
                    title: 'HHS HIPAA Information',
                    url: 'https://www.hhs.gov/hipaa',
                    description: 'Official U.S. Department of Health & Human Services HIPAA portal',
                  },
                  {
                    title: 'HIPAA Security Rule',
                    url: 'https://www.hhs.gov/hipaa/for-professionals/security',
                    description: 'Technical and administrative security requirements',
                  },
                  {
                    title: 'Breach Notification Rule',
                    url: 'https://www.hhs.gov/hipaa/for-professionals/breach-notification',
                    description: 'Requirements for reporting PHI breaches',
                  },
                  {
                    title: 'Business Associate Guidance',
                    url: 'https://www.hhs.gov/hipaa/for-professionals/privacy/guidance/business-associates',
                    description: 'Information about BAA requirements',
                  },
                ].map((item, index) => (
                  <a
                    key={index}
                    href={item.url}
                    target="_blank"
                    rel="noopener noreferrer"
                    className="flex items-start gap-3 p-4 bg-white border border-gray-200 rounded-lg hover:border-brand-ocean hover:shadow-sm transition-all"
                  >
                    <ExternalLink className="w-5 h-5 text-brand-ocean flex-shrink-0 mt-0.5" />
                    <div>
                      <h4 className="font-medium text-brand-navy text-sm">{item.title}</h4>
                      <p className="text-xs text-gray-600 mt-1">{item.description}</p>
                    </div>
                  </a>
                ))}
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
              <h2 className="text-xl font-bold text-white mb-2">Questions About HIPAA Compliance?</h2>
              <p className="text-brand-sky-light mb-4">
                Contact us for information about specific equipment and software compliance
              </p>
              <a
                href="mailto:sales@bluecross.tech"
                className="inline-flex items-center gap-2 bg-white text-brand-navy px-6 py-3 rounded-lg font-medium hover:bg-brand-sky-light transition-colors"
              >
                <Mail size={18} />
                sales@bluecross.tech
              </a>
              <p className="text-sm text-brand-sky-light/80 mt-4">
                For legal advice regarding HIPAA compliance, please consult a qualified healthcare attorney.
              </p>
            </motion.div>
          </div>
        </Container>
      </section>
    </main>
  );
}

export default HipaaCompliance;
