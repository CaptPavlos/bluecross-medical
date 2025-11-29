import { Link } from 'react-router-dom';
import { Mail, Phone, MapPin, Linkedin, Lock } from 'lucide-react';
import { COMPANY_INFO } from '../../lib/constants';
import Container from '../Common/Container';
import { useAuth } from '../../context/AuthContext';

function Footer() {
  const currentYear = new Date().getFullYear();
  const { isAdmin } = useAuth();

  return (
    <>
      {/* Mobile Footer - Minimal with legal links only */}
      <footer className="md:hidden bg-brand-navy text-white py-6 mb-14">
        <Container>
          <div className="flex justify-center items-center gap-4 text-sm text-gray-400">
            <Link to="/privacy" className="hover:text-brand-ocean transition-colors">
              Privacy
            </Link>
            <span className="text-gray-600">•</span>
            <Link to="/terms" className="hover:text-brand-ocean transition-colors">
              Terms
            </Link>
            <span className="text-gray-600">•</span>
            <Link to="/hipaa" className="hover:text-brand-ocean transition-colors">
              HIPAA
            </Link>
          </div>
        </Container>
      </footer>

      {/* Desktop Footer - Full version */}
      <footer className="hidden md:block bg-gradient-to-b from-brand-navy to-brand-navy text-white pt-12 pb-8 relative overflow-hidden">
        {/* Wave decoration at top */}
        <div className="absolute top-0 left-0 right-0 h-16 opacity-10">
          <svg className="w-full h-full" viewBox="0 0 1440 100" preserveAspectRatio="none">
            <path fill="#0077B6" d="M0,50 C200,0 400,100 600,50 C800,0 1000,100 1200,50 C1400,0 1440,50 1440,50 L1440,0 L0,0 Z"></path>
          </svg>
        </div>
        <Container className="relative z-10">
          <div className="grid grid-cols-1 md:grid-cols-4 gap-8 mb-8">
            {/* Brand */}
            <div className="md:col-span-2">
              <Link to="/" className="flex items-center space-x-2 mb-4">
                <div className="w-10 h-10 bg-brand-ocean rounded-lg flex items-center justify-center">
                  <span className="text-white font-bold text-xl">B+</span>
                </div>
                <span className="font-bold text-xl text-white">
                  Medical
                </span>
              </Link>
              <p className="text-gray-400 mb-4 max-w-md">
                {COMPANY_INFO.description}
              </p>
              <div className="flex space-x-4">
                <a
                  href={COMPANY_INFO.social.linkedin}
                  target="_blank"
                  rel="noopener noreferrer"
                  className="p-2 bg-white/10 rounded-lg hover:bg-brand-ocean transition-colors"
                  aria-label="Mariners Medico Guide"
                >
                  <Linkedin size={18} />
                </a>
              </div>
            </div>

            {/* Contact */}
            <div>
              <h3 className="font-semibold text-lg mb-4">Contact</h3>
              <ul className="space-y-3">
                <li className="flex items-start space-x-3 text-gray-400">
                  <Mail size={18} className="mt-1 flex-shrink-0" />
                  <a href={`mailto:${COMPANY_INFO.email}`} className="hover:text-brand-ocean transition-colors">
                    {COMPANY_INFO.email}
                  </a>
                </li>
                <li className="flex items-start space-x-3 text-gray-400">
                  <Phone size={18} className="mt-1 flex-shrink-0" />
                  <a href={`tel:${COMPANY_INFO.phone}`} className="hover:text-brand-ocean transition-colors">
                    {COMPANY_INFO.phone}
                  </a>
                </li>
                <li className="flex items-start space-x-3 text-gray-400">
                  <MapPin size={18} className="mt-1 flex-shrink-0" />
                  <span>{COMPANY_INFO.address}</span>
                </li>
              </ul>
            </div>
          </div>

          {/* Bottom */}
          <div className="pt-8 border-t border-white/10 flex flex-col md:flex-row justify-between items-center text-gray-400 text-sm">
            <p>&copy; {currentYear} {COMPANY_INFO.name}. All rights reserved.</p>
            <div className="flex items-center space-x-6 mt-4 md:mt-0">
              <div className="flex space-x-6">
                <Link to="/privacy" className="hover:text-brand-ocean transition-colors">
                  Privacy Policy
                </Link>
                <Link to="/terms" className="hover:text-brand-ocean transition-colors">
                  Terms of Service
                </Link>
                <Link to="/hipaa" className="hover:text-brand-ocean transition-colors">
                  HIPAA Compliance
                </Link>
              </div>
              <span className="text-gray-500">|</span>
              <a 
                href="https://marsoft.ai" 
                target="_blank" 
                rel="noopener noreferrer"
                className="hover:text-brand-ocean transition-colors"
              >
                Made by Marsoft.ai
              </a>
              <span className="text-gray-500">|</span>
              <Link 
                to={isAdmin ? "/admin" : "/admin/login"} 
                className="hover:text-brand-ocean transition-colors flex items-center gap-1"
              >
                <Lock size={12} />
                {isAdmin ? 'Admin Panel' : 'Admin'}
              </Link>
            </div>
          </div>
        </Container>
      </footer>
    </>
  );
}

export default Footer;
