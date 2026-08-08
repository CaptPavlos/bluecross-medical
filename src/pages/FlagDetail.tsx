/**
 * @fileoverview Flag-state performance record and review-gated medical summary.
 */
import type { ReactNode } from 'react';
import { useParams, Link } from 'react-router-dom';
import { motion } from 'framer-motion';
import {
  AlertCircle,
  AlertTriangle,
  ArrowLeft,
  CheckCircle,
  ExternalLink,
  Info,
  Mail,
  Phone,
} from 'lucide-react';
import Container from '../components/Common/Container';
import { FLAG_STATES } from '../lib/flagStates';
import { SEOHead } from '../components/SEO';
import type { ParisMouStatus } from '../lib/types';

const STATUS_META: Record<ParisMouStatus, {
  badge: string;
  panel: string;
  title: string;
  description: string;
}> = {
  white: {
    badge: 'border-green-200 bg-green-100 text-green-800',
    panel: 'border-green-200 bg-green-50 text-green-900',
    title: 'White list',
    description: 'Quality performance in the current Paris MoU port-state-control dataset.',
  },
  grey: {
    badge: 'border-yellow-200 bg-yellow-100 text-yellow-900',
    panel: 'border-yellow-200 bg-yellow-50 text-yellow-950',
    title: 'Grey list',
    description: 'Average performance in the current Paris MoU port-state-control dataset.',
  },
  black: {
    badge: 'border-red-200 bg-red-100 text-red-800',
    panel: 'border-red-200 bg-red-50 text-red-950',
    title: 'Black list',
    description: 'Poor performance in the current Paris MoU port-state-control dataset.',
  },
  'not-listed': {
    badge: 'border-slate-200 bg-slate-100 text-slate-700',
    panel: 'border-slate-200 bg-slate-50 text-slate-800',
    title: 'Not listed',
    description: 'This flag is not included in the current Paris MoU performance edition. This is not a performance rating.',
  },
};

function formatDate(value: string) {
  return new Intl.DateTimeFormat('en-GB', {
    day: 'numeric',
    month: 'long',
    year: 'numeric',
    timeZone: 'UTC',
  }).format(new Date(`${value}T00:00:00Z`));
}

function inlineText(value: string): ReactNode {
  const parts = value.split(/(\*\*[^*]+\*\*)/g).filter(Boolean);
  return parts.map((part, index) => part.startsWith('**') && part.endsWith('**')
    ? <strong key={index}>{part.slice(2, -2)}</strong>
    : part);
}

/** Render the constrained legacy summary format with valid heading/list structure. */
function MedicalSummary({ content }: { content: string }) {
  const nodes: ReactNode[] = [];
  let listItems: string[] = [];

  const flushList = () => {
    if (!listItems.length) return;
    const items = listItems;
    listItems = [];
    nodes.push(
      <ul key={`list-${nodes.length}`} className="my-3 list-disc space-y-1 pl-6 text-gray-700">
        {items.map((item, index) => <li key={index}>{inlineText(item)}</li>)}
      </ul>,
    );
  };

  for (const rawLine of content.split(/\r?\n/)) {
    const line = rawLine.trim();
    if (!line) {
      flushList();
      continue;
    }
    if (line.startsWith('- ')) {
      listItems.push(line.slice(2));
      continue;
    }

    flushList();
    if (line.startsWith('### ')) {
      nodes.push(<h4 key={nodes.length} className="mb-2 mt-5 text-base font-semibold text-brand-navy">{inlineText(line.slice(4))}</h4>);
    } else if (line.startsWith('## ')) {
      nodes.push(<h3 key={nodes.length} className="mb-3 mt-6 text-lg font-semibold text-brand-navy">{inlineText(line.slice(3))}</h3>);
    } else if (line.startsWith('# ')) {
      nodes.push(<h2 key={nodes.length} className="mb-4 mt-0 text-2xl font-bold text-brand-navy">{inlineText(line.slice(2))}</h2>);
    } else {
      nodes.push(<p key={nodes.length} className="mb-3 text-gray-700">{inlineText(line)}</p>);
    }
  }
  flushList();
  return <div>{nodes}</div>;
}

function StatusIcon({ status }: { status: ParisMouStatus }) {
  if (status === 'white') return <CheckCircle className="shrink-0 text-green-600" size={24} aria-hidden="true" />;
  if (status === 'not-listed') return <Info className="shrink-0 text-slate-600" size={24} aria-hidden="true" />;
  return <AlertTriangle className={status === 'black' ? 'shrink-0 text-red-600' : 'shrink-0 text-yellow-600'} size={24} aria-hidden="true" />;
}

/** Detailed flag record with performance and medical provenance kept separate. */
function FlagDetail() {
  const { slug } = useParams<{ slug: string }>();
  const flag = FLAG_STATES.find((candidate) => candidate.slug === slug);

  if (!flag) {
    return (
      <main className="flex flex-1 items-center justify-center px-4 py-24">
        <div className="text-center">
          <h1 className="mb-4 text-2xl font-bold text-brand-navy">Flag state not found</h1>
          <Link to="/flags" className="text-brand-ocean hover:underline">← Back to flag database</Link>
        </div>
      </main>
    );
  }

  const status = STATUS_META[flag.paris_mou_status];
  const keywords = [
    `${flag.country_name} flag state`,
    `${flag.country_name} maritime medical`,
    'flag state regulations',
    'ship medical requirements',
    flag.paris_mou_status !== 'not-listed' ? `Paris MoU ${flag.paris_mou_status} list` : 'Paris MoU performance list',
  ];

  return (
    <main className="flex-1">
      <SEOHead
        title={`${flag.country_name} Flag State Medical Requirements`}
        description={flag.excerpt}
        url={`/flags/${flag.slug}`}
        keywords={keywords}
      />

      <section className="bg-gradient-to-br from-brand-navy to-brand-blue pb-12 pt-24 md:pb-16 md:pt-28">
        <Container>
          <Link
            to="/flags"
            className="mb-6 inline-flex min-h-11 items-center gap-2 text-brand-sky-light transition-colors hover:text-white"
          >
            <ArrowLeft size={18} aria-hidden="true" />
            Back to flag database
          </Link>

          <motion.div
            initial={{ opacity: 0, y: 20 }}
            animate={{ opacity: 1, y: 0 }}
            className="flex flex-col items-start gap-4 sm:flex-row sm:gap-6"
          >
            <span className="text-6xl md:text-8xl" aria-hidden="true">{flag.flag_emoji}</span>
            <div className="min-w-0">
              <div className="mb-3 flex flex-wrap items-center gap-3">
                <h1 className="break-words text-3xl font-bold text-white md:text-4xl">{flag.country_name}</h1>
                <span className={`whitespace-nowrap rounded-full border px-3 py-1 text-sm font-medium ${status.badge}`}>
                  {status.title}{flag.paris_mou_rank !== null ? ` · global rank #${flag.paris_mou_rank}` : ''}
                </span>
              </div>
              <p className="max-w-3xl text-base text-brand-sky-light sm:text-lg">{flag.excerpt}</p>
            </div>
          </motion.div>
        </Container>
      </section>

      <section className="border-b border-amber-200 bg-amber-50 py-4" aria-labelledby="medical-review-heading">
        <Container>
          <div className="flex items-start gap-3">
            <AlertCircle className="mt-0.5 shrink-0 text-amber-700" size={20} aria-hidden="true" />
            <div>
              <h2 id="medical-review-heading" className="font-semibold text-amber-950">Medical review: needs authoritative review</h2>
              <p className="mt-1 text-sm text-amber-900">{flag.medical_disclaimer}</p>
            </div>
          </div>
        </Container>
      </section>

      <section className="py-8 md:py-12">
        <Container>
          <div className="grid gap-8 lg:grid-cols-3">
            <div className="space-y-6 lg:col-span-2">
              <article className="rounded-xl border border-gray-200 bg-white p-5 sm:p-6 md:p-8" aria-labelledby="medical-summary-heading">
                <div className="mb-5 border-b border-gray-100 pb-4">
                  <p id="medical-summary-heading" className="text-sm font-semibold uppercase tracking-wide text-amber-700">
                    Unverified medical summary
                  </p>
                  <p className="mt-1 text-sm text-gray-600">
                    The legacy record is retained for review, but unreviewed operational claims are not shown. Paris MoU performance data never updates medical guidance automatically.
                  </p>
                </div>
                <MedicalSummary content={flag.content} />
              </article>

              <section className="rounded-xl border border-gray-200 bg-white p-5 sm:p-6" aria-labelledby="provenance-heading">
                <h2 id="provenance-heading" className="text-lg font-semibold text-brand-navy">Medical source provenance</h2>
                {flag.medical_sources.length > 0 ? (
                  <ul className="mt-4 space-y-3">
                    {flag.medical_sources.map((source) => (
                      <li key={source.url} className="rounded-lg border border-gray-200 p-3">
                        <a
                          href={source.url}
                          target="_blank"
                          rel="noopener noreferrer"
                          className="inline-flex items-start gap-2 font-medium text-brand-ocean hover:underline"
                        >
                          <span>{source.title}</span>
                          <ExternalLink size={14} className="mt-1 shrink-0" aria-hidden="true" />
                        </a>
                        {source.authority && <p className="mt-1 text-xs text-gray-600">Publisher/reference: {source.authority}</p>}
                        <p className="mt-1 text-xs text-amber-700">Review date: not recorded</p>
                      </li>
                    ))}
                  </ul>
                ) : (
                  <div className="mt-4 rounded-lg border border-amber-200 bg-amber-50 p-3 text-sm text-amber-900">
                    No flag-specific authoritative medical source is recorded yet. Treat all medical fields as unknown until reviewed.
                  </div>
                )}
              </section>
            </div>

            <aside className="order-first flex flex-col gap-6 lg:order-last" aria-label="Flag record facts and contacts">
              {flag.tmas && (
                <section className="rounded-xl bg-gradient-to-br from-green-700 to-green-800 p-5 text-white sm:p-6" aria-labelledby="tmas-heading">
                  <h2 id="tmas-heading" className="font-semibold">TMAS contact</h2>
                  <p className="mt-2 text-lg font-medium">{flag.tmas.name}</p>
                  <div className="mt-4 grid gap-2">
                    <a
                      href={`tel:${flag.tmas.phone.replace(/[^+\d]/g, '')}`}
                      className="inline-flex min-h-11 items-center gap-2 rounded-lg bg-white px-3 py-2 text-sm font-semibold text-green-800 hover:bg-green-50"
                    >
                      <Phone size={16} aria-hidden="true" /> Call {flag.tmas.phone}
                    </a>
                    {flag.tmas.email && (
                      <a
                        href={`mailto:${flag.tmas.email}`}
                        className="inline-flex min-h-11 items-center gap-2 rounded-lg border border-white/40 px-3 py-2 text-sm font-medium hover:bg-white/10"
                      >
                        <Mail size={16} aria-hidden="true" /> Email TMAS
                      </a>
                    )}
                    {flag.tmas.website && (
                      <a
                        href={flag.tmas.website}
                        target="_blank"
                        rel="noopener noreferrer"
                        className="inline-flex min-h-11 items-center gap-2 rounded-lg border border-white/40 px-3 py-2 text-sm font-medium hover:bg-white/10"
                      >
                        <ExternalLink size={16} aria-hidden="true" /> TMAS website
                      </a>
                    )}
                  </div>
                  <dl className="mt-4 space-y-2 text-sm text-green-50">
                    <div><dt className="inline font-semibold">Hours: </dt><dd className="inline">{flag.tmas.hours}</dd></div>
                    {flag.tmas.languages?.length ? (
                      <div><dt className="inline font-semibold">Languages: </dt><dd className="inline">{flag.tmas.languages.join(', ')}</dd></div>
                    ) : null}
                  </dl>
                  {flag.tmas.notes && <p className="mt-3 text-xs text-green-100">{flag.tmas.notes}</p>}
                  <p className="mt-3 border-t border-white/20 pt-3 text-xs text-green-100">
                    Contact details are part of an unverified legacy summary. Confirm them before relying on them in an emergency plan.
                  </p>
                </section>
              )}

              <section className={`rounded-xl border p-5 sm:p-6 ${status.panel}`} aria-labelledby="performance-heading">
                <h2 id="performance-heading" className="font-semibold">Paris MoU performance</h2>
                <div className="mt-3 flex items-start gap-2">
                  <StatusIcon status={flag.paris_mou_status} />
                  <div>
                    <p className="text-lg font-bold">{status.title}</p>
                    <p className="mt-1 text-sm">{status.description}</p>
                  </div>
                </div>
                <dl className="mt-4 grid grid-cols-2 gap-3 border-t border-current/10 pt-4 text-sm">
                  <div>
                    <dt className="opacity-70">Edition</dt>
                    <dd className="font-semibold">{flag.paris_mou_edition}</dd>
                  </div>
                  <div>
                    <dt className="opacity-70">Global rank</dt>
                    <dd className="font-semibold">{flag.paris_mou_rank ?? 'Not listed'}</dd>
                  </div>
                  <div>
                    <dt className="opacity-70">Inspections</dt>
                    <dd className="font-semibold">{flag.paris_mou_inspections?.toLocaleString() ?? 'Not reported'}</dd>
                  </div>
                  <div>
                    <dt className="opacity-70">Detentions</dt>
                    <dd className="font-semibold">{flag.paris_mou_detentions?.toLocaleString() ?? 'Not reported'}</dd>
                  </div>
                </dl>
                <p className="mt-4 text-xs">
                  Effective <time dateTime={flag.paris_mou_valid_from}>{formatDate(flag.paris_mou_valid_from)}</time>
                  {' '}to <time dateTime={flag.paris_mou_valid_until}>{formatDate(flag.paris_mou_valid_until)}</time>.
                </p>
                <a
                  href={flag.paris_mou_source_url}
                  target="_blank"
                  rel="noopener noreferrer"
                  className="mt-4 inline-flex min-h-11 items-center gap-2 rounded-lg border border-current/30 px-3 py-2 text-sm font-medium hover:bg-white/50"
                >
                  Official performance source <ExternalLink size={14} aria-hidden="true" />
                </a>
              </section>

              <section className="rounded-xl border border-gray-200 bg-white p-5 sm:p-6" aria-labelledby="quick-info-heading">
                <h2 id="quick-info-heading" className="font-semibold text-brand-navy">Medical record fields</h2>
                <dl className="mt-4 space-y-3 text-sm">
                  <div>
                    <dt className="text-gray-500">Country code</dt>
                    <dd className="font-medium text-brand-navy">{flag.country_code}</dd>
                  </div>
                  <div>
                    <dt className="text-gray-500">Maritime authority</dt>
                    <dd className="font-medium text-brand-navy">
                      {flag.maritime_authority
                        ? `${flag.maritime_authority} (unverified)`
                        : 'Unknown — review required'}
                    </dd>
                  </div>
                  <div>
                    <dt className="text-gray-500">Inspection interval</dt>
                    <dd className="font-medium text-brand-navy">
                      {flag.inspection_interval_months !== null
                        ? `${flag.inspection_interval_months} months (unverified)`
                        : 'Unknown — review required'}
                    </dd>
                  </div>
                  <div>
                    <dt className="text-gray-500">Medical categories</dt>
                    <dd className="font-medium text-brand-navy">
                      {flag.medical_categories?.length
                        ? `${flag.medical_categories.join(', ')} (unverified)`
                        : 'Unknown — review required'}
                    </dd>
                  </div>
                </dl>
                {flag.authority_website && (
                  <a
                    href={flag.authority_website}
                    target="_blank"
                    rel="noopener noreferrer"
                    className="mt-4 inline-flex min-h-11 items-center gap-2 text-sm font-medium text-brand-ocean hover:underline"
                  >
                    Authority website <ExternalLink size={14} aria-hidden="true" />
                  </a>
                )}
              </section>

              <section className="rounded-xl border border-gray-200 bg-white p-5 sm:p-6" aria-labelledby="requirements-heading">
                <h2 id="requirements-heading" className="font-semibold text-brand-navy">Recorded requirement notes</h2>
                {flag.key_requirements.length > 0 ? (
                  <ul className="mt-4 space-y-2">
                    {flag.key_requirements.map((requirement) => (
                      <li key={requirement} className="flex items-start gap-2 text-sm text-gray-700">
                        <CheckCircle size={16} className="mt-0.5 shrink-0 text-brand-ocean" aria-hidden="true" />
                        <span>{requirement} <span className="text-amber-700">(unverified)</span></span>
                      </li>
                    ))}
                  </ul>
                ) : (
                  <p className="mt-3 text-sm text-gray-600">No authoritative flag-specific requirements are recorded yet.</p>
                )}
              </section>

              {flag.equipment_differences && (
                <section className="rounded-xl border border-amber-200 bg-amber-50 p-5 sm:p-6" aria-labelledby="equipment-heading">
                  <h2 id="equipment-heading" className="font-semibold text-brand-navy">Equipment notes (unverified)</h2>
                  <dl className="mt-3 space-y-2 text-sm text-gray-800">
                    <div><dt className="inline font-medium">AED: </dt><dd className="inline">{flag.equipment_differences.aed_required ? 'Recorded as required' : (flag.equipment_differences.aed_recommendation || 'No verified requirement recorded')}</dd></div>
                    <div><dt className="inline font-medium">Oxygen equipment: </dt><dd className="inline">{flag.equipment_differences.oxygen_equipment_required ? 'Recorded as required' : 'No verified requirement recorded'}</dd></div>
                    {flag.equipment_differences.stretcher_required && (
                      <div><dt className="inline font-medium">Stretcher: </dt><dd className="inline">Recorded as required</dd></div>
                    )}
                  </dl>
                </section>
              )}
            </aside>
          </div>
        </Container>
      </section>
    </main>
  );
}

export default FlagDetail;
