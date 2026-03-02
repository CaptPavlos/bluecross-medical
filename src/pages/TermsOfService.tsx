/**
 * @fileoverview Terms of service legal page.
 */
import { motion } from 'framer-motion';
import { FileText, ShoppingCart, Package, AlertTriangle, Scale, RefreshCw, Mail } from 'lucide-react';
import Container from '../components/Common/Container';

/**
 * Terms of service page outlining usage conditions and policies.
 */
function TermsOfService() {
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
              <FileText className="w-8 h-8 text-white" />
            </div>
            <h1 className="text-3xl md:text-4xl font-bold text-white mb-4">
              Terms of Service
            </h1>
            <p className="text-lg text-brand-sky-light max-w-2xl mx-auto">
              Platform Use & Equipment Sales Terms
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
            {/* Agreement */}
            <motion.div
              initial={{ opacity: 0, y: 20 }}
              whileInView={{ opacity: 1, y: 0 }}
              viewport={{ once: true }}
              className="mb-12"
            >
              <div className="flex items-center gap-3 mb-4">
                <Scale className="w-6 h-6 text-brand-ocean" />
                <h2 className="text-2xl font-bold text-brand-navy">1. Agreement to Terms</h2>
              </div>
              <div className="prose prose-gray max-w-none">
                <p className="text-gray-600 mb-4">
                  By accessing or using the BlueCross Medical website (bluecross.tech), mobile applications, 
                  or any related services (collectively, the "Platform"), you agree to be bound by these 
                  Terms of Service ("Terms"). If you do not agree to these Terms, do not use the Platform.
                </p>
                <div className="bg-brand-ocean/5 border border-brand-ocean/20 rounded-lg p-4">
                  <p className="text-sm text-brand-navy">
                    <strong>Service Provider:</strong> BlueCross Medical<br />
                    <strong>Registration:</strong> Greece<br />
                    <strong>Contact:</strong> bluecross@marsoft.ai
                  </p>
                </div>
              </div>
            </motion.div>

            {/* Platform Use */}
            <motion.div
              initial={{ opacity: 0, y: 20 }}
              whileInView={{ opacity: 1, y: 0 }}
              viewport={{ once: true }}
              className="mb-12"
            >
              <div className="flex items-center gap-3 mb-4">
                <FileText className="w-6 h-6 text-brand-ocean" />
                <h2 className="text-2xl font-bold text-brand-navy">2. Use of Platform Data</h2>
              </div>
              
              <div className="space-y-6">
                <div className="bg-white border border-gray-200 rounded-xl p-6">
                  <h3 className="font-semibold text-brand-navy mb-3">2.1 Flag Regulations Database</h3>
                  <p className="text-gray-600 text-sm mb-4">
                    The Flag Regulations Database is provided free of charge for informational purposes only. 
                    By using this database, you acknowledge and agree:
                  </p>
                  <ul className="space-y-2 text-gray-600 text-sm">
                    <li className="flex items-start gap-2">
                      <span className="w-1.5 h-1.5 bg-brand-ocean rounded-full mt-2 flex-shrink-0"></span>
                      <span>Information is compiled from official sources but may not reflect the most current regulations</span>
                    </li>
                    <li className="flex items-start gap-2">
                      <span className="w-1.5 h-1.5 bg-brand-ocean rounded-full mt-2 flex-shrink-0"></span>
                      <span>You must verify all requirements with the relevant flag state authority before compliance</span>
                    </li>
                    <li className="flex items-start gap-2">
                      <span className="w-1.5 h-1.5 bg-brand-ocean rounded-full mt-2 flex-shrink-0"></span>
                      <span>BlueCross is not liable for any errors, omissions, or outdated information</span>
                    </li>
                    <li className="flex items-start gap-2">
                      <span className="w-1.5 h-1.5 bg-brand-ocean rounded-full mt-2 flex-shrink-0"></span>
                      <span>The database does not constitute legal or professional compliance advice</span>
                    </li>
                  </ul>
                </div>

                <div className="bg-white border border-gray-200 rounded-xl p-6">
                  <h3 className="font-semibold text-brand-navy mb-3">2.2 Educational Content</h3>
                  <p className="text-gray-600 text-sm mb-4">
                    Training materials, articles, and educational content on the Platform:
                  </p>
                  <ul className="space-y-2 text-gray-600 text-sm">
                    <li className="flex items-start gap-2">
                      <span className="w-1.5 h-1.5 bg-brand-ocean rounded-full mt-2 flex-shrink-0"></span>
                      <span>Are for general educational purposes and do not replace certified training programs</span>
                    </li>
                    <li className="flex items-start gap-2">
                      <span className="w-1.5 h-1.5 bg-brand-ocean rounded-full mt-2 flex-shrink-0"></span>
                      <span>May not be reproduced, distributed, or used commercially without written permission</span>
                    </li>
                    <li className="flex items-start gap-2">
                      <span className="w-1.5 h-1.5 bg-brand-ocean rounded-full mt-2 flex-shrink-0"></span>
                      <span>Are protected by copyright and intellectual property laws</span>
                    </li>
                  </ul>
                </div>

                <div className="bg-white border border-gray-200 rounded-xl p-6">
                  <h3 className="font-semibold text-brand-navy mb-3">2.3 Acceptable Use</h3>
                  <p className="text-gray-600 text-sm mb-4">You agree NOT to:</p>
                  <ul className="space-y-2 text-gray-600 text-sm">
                    <li className="flex items-start gap-2">
                      <span className="w-1.5 h-1.5 bg-red-500 rounded-full mt-2 flex-shrink-0"></span>
                      <span>Scrape, copy, or systematically download database content for commercial purposes</span>
                    </li>
                    <li className="flex items-start gap-2">
                      <span className="w-1.5 h-1.5 bg-red-500 rounded-full mt-2 flex-shrink-0"></span>
                      <span>Misrepresent the source of information or claim it as your own</span>
                    </li>
                    <li className="flex items-start gap-2">
                      <span className="w-1.5 h-1.5 bg-red-500 rounded-full mt-2 flex-shrink-0"></span>
                      <span>Use automated systems to access the Platform without permission</span>
                    </li>
                    <li className="flex items-start gap-2">
                      <span className="w-1.5 h-1.5 bg-red-500 rounded-full mt-2 flex-shrink-0"></span>
                      <span>Interfere with or disrupt the Platform's operation or security</span>
                    </li>
                  </ul>
                </div>
              </div>
            </motion.div>

            {/* Equipment Sales */}
            <motion.div
              initial={{ opacity: 0, y: 20 }}
              whileInView={{ opacity: 1, y: 0 }}
              viewport={{ once: true }}
              className="mb-12"
            >
              <div className="flex items-center gap-3 mb-4">
                <ShoppingCart className="w-6 h-6 text-brand-ocean" />
                <h2 className="text-2xl font-bold text-brand-navy">3. Equipment Sales Terms</h2>
              </div>

              <div className="space-y-6">
                <div className="bg-white border border-gray-200 rounded-xl p-6">
                  <h3 className="font-semibold text-brand-navy mb-3">3.1 Product Information</h3>
                  <ul className="space-y-2 text-gray-600 text-sm">
                    <li className="flex items-start gap-2">
                      <span className="w-1.5 h-1.5 bg-brand-ocean rounded-full mt-2 flex-shrink-0"></span>
                      <span>All products are described as accurately as possible; images may vary slightly from actual products</span>
                    </li>
                    <li className="flex items-start gap-2">
                      <span className="w-1.5 h-1.5 bg-brand-ocean rounded-full mt-2 flex-shrink-0"></span>
                      <span>Prices are in EUR unless otherwise stated and exclude applicable taxes and shipping</span>
                    </li>
                    <li className="flex items-start gap-2">
                      <span className="w-1.5 h-1.5 bg-brand-ocean rounded-full mt-2 flex-shrink-0"></span>
                      <span>We reserve the right to modify prices and discontinue products without notice</span>
                    </li>
                    <li className="flex items-start gap-2">
                      <span className="w-1.5 h-1.5 bg-brand-ocean rounded-full mt-2 flex-shrink-0"></span>
                      <span>Product availability is subject to stock levels and supplier availability</span>
                    </li>
                  </ul>
                </div>

                <div className="bg-white border border-gray-200 rounded-xl p-6">
                  <h3 className="font-semibold text-brand-navy mb-3">3.2 Orders & Payment</h3>
                  <ul className="space-y-2 text-gray-600 text-sm">
                    <li className="flex items-start gap-2">
                      <span className="w-1.5 h-1.5 bg-brand-ocean rounded-full mt-2 flex-shrink-0"></span>
                      <span>Orders are confirmed upon receipt of payment and stock verification</span>
                    </li>
                    <li className="flex items-start gap-2">
                      <span className="w-1.5 h-1.5 bg-brand-ocean rounded-full mt-2 flex-shrink-0"></span>
                      <span>Payment is processed securely through third-party payment providers</span>
                    </li>
                    <li className="flex items-start gap-2">
                      <span className="w-1.5 h-1.5 bg-brand-ocean rounded-full mt-2 flex-shrink-0"></span>
                      <span>We reserve the right to cancel orders due to pricing errors or suspected fraud</span>
                    </li>
                    <li className="flex items-start gap-2">
                      <span className="w-1.5 h-1.5 bg-brand-ocean rounded-full mt-2 flex-shrink-0"></span>
                      <span>VAT is applied according to EU regulations based on delivery location</span>
                    </li>
                  </ul>
                </div>

                <div className="bg-white border border-gray-200 rounded-xl p-6">
                  <h3 className="font-semibold text-brand-navy mb-3">3.3 Shipping & Delivery</h3>
                  <ul className="space-y-2 text-gray-600 text-sm">
                    <li className="flex items-start gap-2">
                      <span className="w-1.5 h-1.5 bg-brand-ocean rounded-full mt-2 flex-shrink-0"></span>
                      <span>Delivery times are estimates and not guaranteed</span>
                    </li>
                    <li className="flex items-start gap-2">
                      <span className="w-1.5 h-1.5 bg-brand-ocean rounded-full mt-2 flex-shrink-0"></span>
                      <span>Risk of loss transfers to buyer upon delivery to carrier</span>
                    </li>
                    <li className="flex items-start gap-2">
                      <span className="w-1.5 h-1.5 bg-brand-ocean rounded-full mt-2 flex-shrink-0"></span>
                      <span>International orders may be subject to customs duties and import taxes (buyer's responsibility)</span>
                    </li>
                    <li className="flex items-start gap-2">
                      <span className="w-1.5 h-1.5 bg-brand-ocean rounded-full mt-2 flex-shrink-0"></span>
                      <span>We ship to vessel locations worldwide; additional fees may apply for remote destinations</span>
                    </li>
                  </ul>
                </div>
              </div>
            </motion.div>

            {/* Returns & Warranty */}
            <motion.div
              initial={{ opacity: 0, y: 20 }}
              whileInView={{ opacity: 1, y: 0 }}
              viewport={{ once: true }}
              className="mb-12"
            >
              <div className="flex items-center gap-3 mb-4">
                <RefreshCw className="w-6 h-6 text-brand-ocean" />
                <h2 className="text-2xl font-bold text-brand-navy">4. Returns, Refunds & Warranty</h2>
              </div>

              <div className="space-y-6">
                <div className="bg-white border border-gray-200 rounded-xl p-6">
                  <h3 className="font-semibold text-brand-navy mb-3">4.1 EU Consumer Rights (14-Day Withdrawal)</h3>
                  <p className="text-gray-600 text-sm mb-4">
                    EU consumers have the right to withdraw from a purchase within 14 days of receiving goods, 
                    without giving any reason. To exercise this right:
                  </p>
                  <ul className="space-y-2 text-gray-600 text-sm">
                    <li className="flex items-start gap-2">
                      <span className="w-1.5 h-1.5 bg-brand-ocean rounded-full mt-2 flex-shrink-0"></span>
                      <span>Notify us in writing within 14 days of receipt</span>
                    </li>
                    <li className="flex items-start gap-2">
                      <span className="w-1.5 h-1.5 bg-brand-ocean rounded-full mt-2 flex-shrink-0"></span>
                      <span>Return goods in original condition within 14 days of notification</span>
                    </li>
                    <li className="flex items-start gap-2">
                      <span className="w-1.5 h-1.5 bg-brand-ocean rounded-full mt-2 flex-shrink-0"></span>
                      <span>Return shipping costs are the buyer's responsibility</span>
                    </li>
                    <li className="flex items-start gap-2">
                      <span className="w-1.5 h-1.5 bg-brand-ocean rounded-full mt-2 flex-shrink-0"></span>
                      <span>Refund processed within 14 days of receiving returned goods</span>
                    </li>
                  </ul>
                  <div className="mt-4 p-3 bg-amber-50 border border-amber-200 rounded-lg">
                    <p className="text-sm text-amber-800">
                      <strong>Exceptions:</strong> Sealed medical supplies cannot be returned once opened for hygiene reasons. 
                      Custom-configured medical kits are non-refundable.
                    </p>
                  </div>
                </div>

                <div className="bg-white border border-gray-200 rounded-xl p-6">
                  <h3 className="font-semibold text-brand-navy mb-3">4.2 Product Warranty</h3>
                  <ul className="space-y-2 text-gray-600 text-sm">
                    <li className="flex items-start gap-2">
                      <span className="w-1.5 h-1.5 bg-brand-ocean rounded-full mt-2 flex-shrink-0"></span>
                      <span>All products carry manufacturer's warranty as specified in product documentation</span>
                    </li>
                    <li className="flex items-start gap-2">
                      <span className="w-1.5 h-1.5 bg-brand-ocean rounded-full mt-2 flex-shrink-0"></span>
                      <span>EU consumers have a minimum 2-year legal guarantee for defective products</span>
                    </li>
                    <li className="flex items-start gap-2">
                      <span className="w-1.5 h-1.5 bg-brand-ocean rounded-full mt-2 flex-shrink-0"></span>
                      <span>Warranty does not cover damage from misuse, improper storage, or normal wear</span>
                    </li>
                    <li className="flex items-start gap-2">
                      <span className="w-1.5 h-1.5 bg-brand-ocean rounded-full mt-2 flex-shrink-0"></span>
                      <span>Consumable items (medications, single-use supplies) are warranted until expiry date only</span>
                    </li>
                  </ul>
                </div>
              </div>
            </motion.div>

            {/* Medical Equipment Disclaimer */}
            <motion.div
              initial={{ opacity: 0, y: 20 }}
              whileInView={{ opacity: 1, y: 0 }}
              viewport={{ once: true }}
              className="mb-12"
            >
              <div className="flex items-center gap-3 mb-4">
                <Package className="w-6 h-6 text-brand-ocean" />
                <h2 className="text-2xl font-bold text-brand-navy">5. Medical Equipment Disclaimer</h2>
              </div>
              <div className="bg-amber-50 border border-amber-200 rounded-xl p-6">
                <div className="flex items-start gap-3">
                  <AlertTriangle className="w-6 h-6 text-amber-600 flex-shrink-0 mt-1" />
                  <div>
                    <h3 className="font-semibold text-amber-800 mb-2">Important Notice</h3>
                    <ul className="space-y-2 text-amber-800 text-sm">
                      <li className="flex items-start gap-2">
                        <span className="w-1.5 h-1.5 bg-amber-600 rounded-full mt-2 flex-shrink-0"></span>
                        <span>Medical equipment should only be used by trained personnel</span>
                      </li>
                      <li className="flex items-start gap-2">
                        <span className="w-1.5 h-1.5 bg-amber-600 rounded-full mt-2 flex-shrink-0"></span>
                        <span>Buyers are responsible for ensuring equipment meets their flag state requirements</span>
                      </li>
                      <li className="flex items-start gap-2">
                        <span className="w-1.5 h-1.5 bg-amber-600 rounded-full mt-2 flex-shrink-0"></span>
                        <span>Prescription medications require valid prescriptions and may have shipping restrictions</span>
                      </li>
                      <li className="flex items-start gap-2">
                        <span className="w-1.5 h-1.5 bg-amber-600 rounded-full mt-2 flex-shrink-0"></span>
                        <span>BlueCross is not liable for improper use or application of medical equipment</span>
                      </li>
                      <li className="flex items-start gap-2">
                        <span className="w-1.5 h-1.5 bg-amber-600 rounded-full mt-2 flex-shrink-0"></span>
                        <span>Always consult medical professionals for clinical decisions</span>
                      </li>
                    </ul>
                  </div>
                </div>
              </div>
            </motion.div>

            {/* Limitation of Liability */}
            <motion.div
              initial={{ opacity: 0, y: 20 }}
              whileInView={{ opacity: 1, y: 0 }}
              viewport={{ once: true }}
              className="mb-12"
            >
              <div className="flex items-center gap-3 mb-4">
                <Scale className="w-6 h-6 text-brand-ocean" />
                <h2 className="text-2xl font-bold text-brand-navy">6. Limitation of Liability</h2>
              </div>
              <div className="bg-white border border-gray-200 rounded-xl p-6">
                <p className="text-gray-600 text-sm mb-4">
                  To the maximum extent permitted by applicable law:
                </p>
                <ul className="space-y-2 text-gray-600 text-sm">
                  <li className="flex items-start gap-2">
                    <span className="w-1.5 h-1.5 bg-brand-ocean rounded-full mt-2 flex-shrink-0"></span>
                    <span>BlueCross provides the Platform and information "as is" without warranties of any kind</span>
                  </li>
                  <li className="flex items-start gap-2">
                    <span className="w-1.5 h-1.5 bg-brand-ocean rounded-full mt-2 flex-shrink-0"></span>
                    <span>We are not liable for indirect, incidental, or consequential damages</span>
                  </li>
                  <li className="flex items-start gap-2">
                    <span className="w-1.5 h-1.5 bg-brand-ocean rounded-full mt-2 flex-shrink-0"></span>
                    <span>Our total liability shall not exceed the amount paid for the specific product or service</span>
                  </li>
                  <li className="flex items-start gap-2">
                    <span className="w-1.5 h-1.5 bg-brand-ocean rounded-full mt-2 flex-shrink-0"></span>
                    <span>Nothing in these Terms excludes liability for death, personal injury, or fraud</span>
                  </li>
                </ul>
              </div>
            </motion.div>

            {/* Governing Law */}
            <motion.div
              initial={{ opacity: 0, y: 20 }}
              whileInView={{ opacity: 1, y: 0 }}
              viewport={{ once: true }}
              className="mb-12"
            >
              <h2 className="text-2xl font-bold text-brand-navy mb-4">7. Governing Law & Disputes</h2>
              <div className="bg-white border border-gray-200 rounded-xl p-6">
                <ul className="space-y-2 text-gray-600 text-sm">
                  <li className="flex items-start gap-2">
                    <span className="w-1.5 h-1.5 bg-brand-ocean rounded-full mt-2 flex-shrink-0"></span>
                    <span>These Terms are governed by the laws of the Hellenic Republic (Greece)</span>
                  </li>
                  <li className="flex items-start gap-2">
                    <span className="w-1.5 h-1.5 bg-brand-ocean rounded-full mt-2 flex-shrink-0"></span>
                    <span>EU consumers retain protection under their country's mandatory consumer laws</span>
                  </li>
                  <li className="flex items-start gap-2">
                    <span className="w-1.5 h-1.5 bg-brand-ocean rounded-full mt-2 flex-shrink-0"></span>
                    <span>Disputes shall be resolved through the courts of Athens, Greece</span>
                  </li>
                  <li className="flex items-start gap-2">
                    <span className="w-1.5 h-1.5 bg-brand-ocean rounded-full mt-2 flex-shrink-0"></span>
                    <span>EU consumers may use the EU Online Dispute Resolution platform: <a href="https://ec.europa.eu/odr" target="_blank" rel="noopener noreferrer" className="text-brand-ocean hover:underline">ec.europa.eu/odr</a></span>
                  </li>
                </ul>
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
              <h2 className="text-xl font-bold text-white mb-2">Questions About These Terms?</h2>
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
            </motion.div>
          </div>
        </Container>
      </section>
    </main>
  );
}

export default TermsOfService;
