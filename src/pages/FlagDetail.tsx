/**
 * @fileoverview Flag state detail page showing medical requirements.
 */
import { useParams, Link } from 'react-router-dom';
import { motion } from 'framer-motion';
import { ArrowLeft, ExternalLink, CheckCircle, AlertTriangle } from 'lucide-react';
import Container from '../components/Common/Container';
import { FLAG_STATES } from '../lib/flagStates';
import { SEOHead } from '../components/SEO';

/**
 * Detailed view of a single flag state's medical regulations and requirements.
 * Includes TMAS info, yacht requirements, and equipment differences.
 */
function FlagDetail() {
  const { slug } = useParams<{ slug: string }>();
  const flag = FLAG_STATES.find(f => f.slug === slug);

  if (!flag) {
    return (
      <main className="flex-1 flex items-center justify-center">
        <div className="text-center">
          <h1 className="text-2xl font-bold text-brand-navy mb-4">Flag State Not Found</h1>
          <Link to="/flags" className="text-brand-ocean hover:underline">
            ← Back to Flag Database
          </Link>
        </div>
      </main>
    );
  }

  const statusColors = {
    white: { bg: 'bg-green-50', border: 'border-green-200', text: 'text-green-800', badge: 'bg-green-100' },
    grey: { bg: 'bg-yellow-50', border: 'border-yellow-200', text: 'text-yellow-800', badge: 'bg-yellow-100' },
    black: { bg: 'bg-red-50', border: 'border-red-200', text: 'text-red-800', badge: 'bg-red-100' },
  };

  const colors = statusColors[flag.paris_mou_status];

  return (
    <main className="flex-1">
      <SEOHead 
        title={`${flag.country_name} Flag State Medical Requirements`}
        description={flag.excerpt || `Maritime medical regulations and requirements for ${flag.country_name} flagged vessels. TMAS contacts, equipment requirements, and compliance guidance.`}
        url={`/flags/${flag.slug}`}
        keywords={[`${flag.country_name} flag state`, `${flag.country_name} maritime medical`, 'flag state regulations', 'ship medical requirements', flag.paris_mou_status === 'white' ? 'Paris MOU white list' : '']}
      />
      
      {/* Hero */}
      <section className="pt-24 pb-12 md:pt-28 md:pb-16 bg-gradient-to-br from-brand-navy to-brand-blue">
        <Container>
          <Link 
            to="/flags" 
            className="inline-flex items-center gap-2 text-brand-sky-light hover:text-white mb-6 transition-colors"
          >
            <ArrowLeft size={18} />
            Back to Flag Database
          </Link>
          
          <motion.div
            initial={{ opacity: 0, y: 20 }}
            animate={{ opacity: 1, y: 0 }}
            className="flex items-start gap-6"
          >
            <span className="text-6xl md:text-8xl">{flag.flag_emoji}</span>
            <div>
              <div className="flex items-center gap-3 mb-2">
                <h1 className="text-3xl md:text-4xl font-bold text-white">
                  {flag.country_name}
                </h1>
                <span className={`px-3 py-1 rounded-full text-sm font-medium ${colors.badge} ${colors.text}`}>
                  {flag.paris_mou_status.toUpperCase()} LIST
                  {flag.paris_mou_rank && ` #${flag.paris_mou_rank}`}
                </span>
              </div>
              <p className="text-lg text-brand-sky-light max-w-2xl">
                {flag.excerpt}
              </p>
            </div>
          </motion.div>
        </Container>
      </section>

      {/* Content */}
      <section className="py-8 md:py-12">
        <Container>
          <div className="grid lg:grid-cols-3 gap-8">
            {/* Main Content */}
            <div className="lg:col-span-2">
              <div className="bg-white rounded-xl border border-gray-200 p-6 md:p-8">
                <div className="prose prose-brand max-w-none whitespace-pre-line">
                  {flag.content.split('\n').map((line, i) => {
                    if (line.startsWith('# ')) {
                      return <h1 key={i} className="text-2xl font-bold text-brand-navy mt-0 mb-4">{line.replace('# ', '')}</h1>;
                    }
                    if (line.startsWith('## ')) {
                      return <h2 key={i} className="text-xl font-semibold text-brand-navy mt-6 mb-3">{line.replace('## ', '')}</h2>;
                    }
                    if (line.startsWith('### ')) {
                      return <h3 key={i} className="text-lg font-semibold text-brand-navy mt-4 mb-2">{line.replace('### ', '')}</h3>;
                    }
                    if (line.startsWith('- ')) {
                      return <li key={i} className="ml-4 text-gray-700">{line.replace('- ', '')}</li>;
                    }
                    if (line.startsWith('**') && line.endsWith('**')) {
                      return <p key={i} className="font-semibold text-brand-navy">{line.replace(/\*\*/g, '')}</p>;
                    }
                    if (line.trim() === '') {
                      return <br key={i} />;
                    }
                    return <p key={i} className="text-gray-700 mb-2">{line}</p>;
                  })}
                </div>
              </div>
            </div>

            {/* Sidebar */}
            <div className="space-y-6">
              {/* Status Card */}
              <div className={`rounded-xl border p-6 ${colors.bg} ${colors.border}`}>
                <h3 className={`font-semibold mb-3 ${colors.text}`}>
                  Paris MOU Status
                </h3>
                <div className="flex items-center gap-2 mb-4">
                  {flag.paris_mou_status === 'white' ? (
                    <CheckCircle className="text-green-600" size={24} />
                  ) : flag.paris_mou_status === 'black' ? (
                    <AlertTriangle className="text-red-600" size={24} />
                  ) : (
                    <AlertTriangle className="text-yellow-600" size={24} />
                  )}
                  <span className={`text-lg font-bold ${colors.text}`}>
                    {flag.paris_mou_status === 'white' && 'Quality Flag'}
                    {flag.paris_mou_status === 'grey' && 'Average Performance'}
                    {flag.paris_mou_status === 'black' && 'High Risk'}
                  </span>
                </div>
                {flag.paris_mou_rank && (
                  <p className="text-sm text-gray-600">
                    Ranked #{flag.paris_mou_rank} on the {flag.paris_mou_status} list
                  </p>
                )}
              </div>

              {/* Quick Info */}
              <div className="bg-white rounded-xl border border-gray-200 p-6">
                <h3 className="font-semibold text-brand-navy mb-4">Quick Info</h3>
                <dl className="space-y-3 text-sm">
                  <div>
                    <dt className="text-gray-500">Country Code</dt>
                    <dd className="font-medium text-brand-navy">{flag.country_code}</dd>
                  </div>
                  <div>
                    <dt className="text-gray-500">Maritime Authority</dt>
                    <dd className="font-medium text-brand-navy">{flag.maritime_authority}</dd>
                  </div>
                  <div>
                    <dt className="text-gray-500">Inspection Interval</dt>
                    <dd className="font-medium text-brand-navy">{flag.inspection_interval_months} months</dd>
                  </div>
                  <div>
                    <dt className="text-gray-500">Medical Categories</dt>
                    <dd className="font-medium text-brand-navy">{flag.medical_categories.join(', ')}</dd>
                  </div>
                </dl>
                {flag.authority_website && (
                  <a
                    href={flag.authority_website}
                    target="_blank"
                    rel="noopener noreferrer"
                    className="mt-4 inline-flex items-center gap-2 text-brand-ocean hover:underline text-sm"
                  >
                    Official Website <ExternalLink size={14} />
                  </a>
                )}
              </div>

              {/* Key Requirements */}
              <div className="bg-white rounded-xl border border-gray-200 p-6">
                <h3 className="font-semibold text-brand-navy mb-4">Key Requirements</h3>
                <ul className="space-y-2">
                  {flag.key_requirements.map((req, i) => (
                    <li key={i} className="flex items-start gap-2 text-sm text-gray-700">
                      <CheckCircle size={16} className="text-brand-ocean mt-0.5 flex-shrink-0" />
                      {req}
                    </li>
                  ))}
                </ul>
              </div>

              {/* TMAS Contact */}
              {flag.tmas && (
                <div className="bg-gradient-to-br from-green-600 to-green-700 rounded-xl p-6 text-white">
                  <h3 className="font-semibold mb-3">📞 TMAS Contact</h3>
                  <p className="font-medium text-lg">{flag.tmas.name}</p>
                  <div className="mt-3 space-y-2 text-sm">
                    <p className="flex items-center gap-2">
                      <span className="font-semibold">Phone:</span> {flag.tmas.phone}
                    </p>
                    {flag.tmas.email && (
                      <p className="flex items-center gap-2">
                        <span className="font-semibold">Email:</span> {flag.tmas.email}
                      </p>
                    )}
                    <p className="flex items-center gap-2">
                      <span className="font-semibold">Hours:</span> {flag.tmas.hours}
                    </p>
                    {flag.tmas.languages && (
                      <p className="flex items-center gap-2">
                        <span className="font-semibold">Languages:</span> {flag.tmas.languages.join(', ')}
                      </p>
                    )}
                    {flag.tmas.notes && (
                      <p className="text-green-200 text-xs mt-2">{flag.tmas.notes}</p>
                    )}
                  </div>
                </div>
              )}

              {/* Equipment Differences */}
              {flag.equipment_differences && (
                <div className={`rounded-xl p-6 ${flag.equipment_differences.aed_required ? 'bg-amber-50 border-2 border-amber-400' : 'bg-white border border-gray-200'}`}>
                  <h3 className="font-semibold text-brand-navy mb-3">
                    {flag.equipment_differences.aed_required ? '⚡ Equipment (Unique)' : '🩺 Equipment'}
                  </h3>
                  <div className="space-y-2 text-sm">
                    <div className={`flex items-center gap-2 ${flag.equipment_differences.aed_required ? 'text-amber-700 font-bold' : 'text-gray-700'}`}>
                      <span className={flag.equipment_differences.aed_required ? '✓' : '○'}>
                        {flag.equipment_differences.aed_required ? '✓' : '○'}
                      </span>
                      AED: {flag.equipment_differences.aed_required ? 'MANDATORY' : (flag.equipment_differences.aed_recommendation || 'Recommended')}
                    </div>
                    <div className="flex items-center gap-2 text-gray-700">
                      <span>{flag.equipment_differences.oxygen_equipment_required ? '✓' : '○'}</span>
                      Oxygen Equipment: {flag.equipment_differences.oxygen_equipment_required ? 'Required' : 'Recommended'}
                    </div>
                    {flag.equipment_differences.stretcher_required && (
                      <div className="flex items-center gap-2 text-gray-700">
                        <span>✓</span> Stretcher: Required
                      </div>
                    )}
                    {flag.equipment_differences.who_guide_deviations && flag.equipment_differences.who_guide_deviations.length > 0 && (
                      <div className="mt-3 pt-3 border-t border-gray-200">
                        <p className="text-xs font-medium text-gray-500 mb-1">WHO Guide Deviations:</p>
                        <ul className="text-xs text-gray-600 space-y-1">
                          {flag.equipment_differences.who_guide_deviations.map((dev, i) => (
                            <li key={i}>• {dev}</li>
                          ))}
                        </ul>
                      </div>
                    )}
                  </div>
                </div>
              )}

              {/* Yacht Requirements */}
              {flag.yacht_requirements?.applicable && (
                <div className="bg-blue-50 border border-blue-200 rounded-xl p-6">
                  <h3 className="font-semibold text-blue-900 mb-3">⛵ Yacht Regulations</h3>
                  <div className="space-y-2 text-sm text-blue-800">
                    {flag.yacht_requirements.code_name && (
                      <p><span className="font-medium">Code:</span> {flag.yacht_requirements.code_name}</p>
                    )}
                    {flag.yacht_requirements.min_length_meters && (
                      <p><span className="font-medium">Applies to:</span> Yachts ≥{flag.yacht_requirements.min_length_meters}m</p>
                    )}
                    {flag.yacht_requirements.categories && (
                      <p><span className="font-medium">Types:</span> {flag.yacht_requirements.categories.join(', ')}</p>
                    )}
                    {flag.yacht_requirements.differences_from_commercial && (
                      <div className="mt-2 pt-2 border-t border-blue-200">
                        <p className="text-xs font-medium mb-1">Differences from Commercial:</p>
                        <ul className="text-xs space-y-1">
                          {flag.yacht_requirements.differences_from_commercial.map((diff, i) => (
                            <li key={i}>• {diff}</li>
                          ))}
                        </ul>
                      </div>
                    )}
                  </div>
                </div>
              )}

              {/* Official Documents */}
              <div className="bg-gradient-to-br from-brand-navy to-brand-blue rounded-xl p-6 text-white">
                <h3 className="font-semibold mb-4">📄 Official Documents</h3>
                <p className="text-sm text-brand-sky-light mb-4">
                  Download official medical requirements documentation:
                </p>
                <div className="space-y-2">
                  <a
                    href="https://apps.who.int/iris/bitstream/handle/10665/43814/9789240682313_eng.pdf"
                    target="_blank"
                    rel="noopener noreferrer"
                    className="flex items-center gap-2 text-sm text-white hover:text-brand-sky transition-colors"
                  >
                    <ExternalLink size={14} />
                    WHO International Medical Guide for Ships
                  </a>
                  {flag.authority_website && (
                    <a
                      href={flag.authority_website}
                      target="_blank"
                      rel="noopener noreferrer"
                      className="flex items-center gap-2 text-sm text-white hover:text-brand-sky transition-colors"
                    >
                      <ExternalLink size={14} />
                      {flag.maritime_authority} Website
                    </a>
                  )}
                  {flag.tmas?.website && (
                    <a
                      href={flag.tmas.website}
                      target="_blank"
                      rel="noopener noreferrer"
                      className="flex items-center gap-2 text-sm text-white hover:text-brand-sky transition-colors"
                    >
                      <ExternalLink size={14} />
                      TMAS Service Website
                    </a>
                  )}
                </div>
              </div>
            </div>
          </div>
        </Container>
      </section>
    </main>
  );
}

export default FlagDetail;
