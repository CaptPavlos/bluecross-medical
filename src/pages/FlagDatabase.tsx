/**
 * @fileoverview Flag-state medical summary directory and Paris MoU performance data.
 */
import { useMemo, useState } from 'react';
import { Link } from 'react-router-dom';
import { motion } from 'framer-motion';
import { AlertCircle, ChevronRight, ExternalLink, Filter, Search } from 'lucide-react';
import Container from '../components/Common/Container';
import { SEOHead } from '../components/SEO';
import { CURRENT_PARIS_MOU_EDITION } from '../data/parisMou/current';
import { FLAG_STATES } from '../lib/flagStates';
import type { FlagState, ParisMouStatus } from '../lib/types';

type FilterStatus = 'all' | ParisMouStatus;

const STATUS_META: Record<ParisMouStatus, {
  label: string;
  heading: string;
  dot: string;
  badge: string;
  headingColor: string;
}> = {
  white: {
    label: 'White',
    heading: 'White list — quality performance',
    dot: 'bg-green-500',
    badge: 'bg-green-100 text-green-800 border-green-200',
    headingColor: 'text-green-700',
  },
  grey: {
    label: 'Grey',
    heading: 'Grey list — average performance',
    dot: 'bg-yellow-500',
    badge: 'bg-yellow-100 text-yellow-800 border-yellow-200',
    headingColor: 'text-yellow-700',
  },
  black: {
    label: 'Black',
    heading: 'Black list — poor performance',
    dot: 'bg-red-500',
    badge: 'bg-red-100 text-red-800 border-red-200',
    headingColor: 'text-red-700',
  },
  'not-listed': {
    label: 'Not listed',
    heading: 'Not listed in the current performance edition',
    dot: 'bg-slate-400',
    badge: 'bg-slate-100 text-slate-700 border-slate-200',
    headingColor: 'text-slate-700',
  },
};

const STATUS_ORDER: ParisMouStatus[] = ['white', 'grey', 'black', 'not-listed'];

function formatDate(value: string) {
  return new Intl.DateTimeFormat('en-GB', {
    day: 'numeric',
    month: 'long',
    year: 'numeric',
    timeZone: 'UTC',
  }).format(new Date(`${value}T00:00:00Z`));
}

function FlagCard({ flag, index }: { flag: FlagState; index: number }) {
  const status = STATUS_META[flag.paris_mou_status];
  const provenanceLabel = flag.medical_sources.length > 0
    ? `${flag.medical_sources.length} medical source reference${flag.medical_sources.length === 1 ? '' : 's'} recorded`
    : 'No flag-specific medical source recorded';

  return (
    <motion.article
      initial={{ opacity: 0, y: 12 }}
      animate={{ opacity: 1, y: 0 }}
      transition={{ delay: Math.min(index, 8) * 0.035 }}
      className="h-full"
    >
      <Link
        to={`/flags/${flag.slug}`}
        className="group block h-full rounded-xl border border-gray-200 bg-white p-4 transition-all hover:border-brand-ocean/30 hover:shadow-lg focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-brand-ocean focus-visible:ring-offset-2"
      >
        <div className="flex items-start gap-3 sm:gap-4">
          <span className="text-4xl" aria-hidden="true">{flag.flag_emoji}</span>
          <div className="min-w-0 flex-1">
            <div className="mb-2 flex flex-wrap items-center gap-2">
              <h3 className="font-semibold text-brand-navy transition-colors group-hover:text-brand-ocean">
                {flag.country_name}
              </h3>
              <span className={`whitespace-nowrap rounded-full border px-2 py-0.5 text-xs ${status.badge}`}>
                {status.label}{flag.paris_mou_rank !== null ? ` · #${flag.paris_mou_rank}` : ''}
              </span>
            </div>
            <p className="line-clamp-2 text-sm text-brand-gray">{flag.excerpt}</p>
            <div className="mt-3 space-y-1 text-xs">
              <p className="flex items-start gap-1.5 text-amber-700">
                <AlertCircle size={14} className="mt-0.5 shrink-0" aria-hidden="true" />
                <span>Medical review: needs authoritative review</span>
              </p>
              <p className="text-gray-500">{provenanceLabel}</p>
            </div>
            <span className="mt-3 inline-flex items-center gap-1 text-xs font-medium text-brand-ocean">
              View record
              <ChevronRight size={14} className="transition-transform group-hover:translate-x-1" aria-hidden="true" />
            </span>
          </div>
        </div>
      </Link>
    </motion.article>
  );
}

/** Browse performance records separately from review-gated medical summaries. */
function FlagDatabase() {
  const [searchTerm, setSearchTerm] = useState('');
  const [filterStatus, setFilterStatus] = useState<FilterStatus>('all');

  const publishedFlags = useMemo(() => FLAG_STATES.filter((flag) => flag.published), []);
  const counts = useMemo(() => Object.fromEntries(
    STATUS_ORDER.map((status) => [
      status,
      publishedFlags.filter((flag) => flag.paris_mou_status === status).length,
    ]),
  ) as Record<ParisMouStatus, number>, [publishedFlags]);

  const filteredFlags = useMemo(() => {
    const query = searchTerm.trim().toLocaleLowerCase();
    return publishedFlags.filter((flag) => {
      const matchesSearch = !query
        || flag.country_name.toLocaleLowerCase().includes(query)
        || flag.country_code.toLocaleLowerCase().includes(query);
      const matchesFilter = filterStatus === 'all' || flag.paris_mou_status === filterStatus;
      return matchesSearch && matchesFilter;
    });
  }, [filterStatus, publishedFlags, searchTerm]);

  const groupedFlags = useMemo(() => Object.fromEntries(
    STATUS_ORDER.map((status) => [
      status,
      filteredFlags.filter((flag) => flag.paris_mou_status === status),
    ]),
  ) as Record<ParisMouStatus, FlagState[]>, [filteredFlags]);

  return (
    <main className="flex-1">
      <SEOHead
        title="Flag State Medical Regulations Database"
        description="Flag-state onboard medical summaries with clearly separated, current Paris MoU performance data, source provenance, and human review status."
        url="/flags"
        keywords={['flag state regulations', 'maritime medical requirements', 'Paris MoU', 'ship medical compliance', 'TMAS contacts']}
      />

      <section className="bg-gradient-to-br from-brand-navy to-brand-blue pb-12 pt-24 md:pb-16 md:pt-28">
        <Container>
          <motion.div initial={{ opacity: 0, y: 20 }} animate={{ opacity: 1, y: 0 }} className="text-center">
            <h1 className="mb-4 text-3xl font-bold text-white md:text-4xl">Flag regulations</h1>
            <p className="mx-auto max-w-3xl text-base text-brand-sky-light sm:text-lg">
              Explore onboard medical summaries and TMAS contacts. Paris MoU performance is shown as a separate port-state-control dataset and does not establish medical requirements.
            </p>
          </motion.div>
        </Container>
      </section>

      <section className="border-b border-blue-100 bg-blue-50 py-6" aria-labelledby="performance-edition-heading">
        <Container>
          <div className="rounded-xl border border-blue-200 bg-white p-4 sm:p-6">
            <div className="flex flex-col gap-4 lg:flex-row lg:items-start lg:justify-between">
              <div className="max-w-3xl">
                <h2 id="performance-edition-heading" className="font-semibold text-brand-navy">
                  Paris MoU performance list {CURRENT_PARIS_MOU_EDITION.edition}
                </h2>
                <p className="mt-1 text-sm text-gray-700">
                  Based on {CURRENT_PARIS_MOU_EDITION.performance_period} inspections. Effective{' '}
                  <time dateTime={CURRENT_PARIS_MOU_EDITION.valid_from}>{formatDate(CURRENT_PARIS_MOU_EDITION.valid_from)}</time>
                  {' '}to{' '}
                  <time dateTime={CURRENT_PARIS_MOU_EDITION.valid_until}>{formatDate(CURRENT_PARIS_MOU_EDITION.valid_until)}</time>.
                </p>
                <p className="mt-2 text-xs text-gray-600">
                  Performance bands describe port-state-control outcomes. They are not evidence of a flag state’s medicine chest, equipment, inspection interval, or clinical rules.
                </p>
              </div>
              <a
                href={CURRENT_PARIS_MOU_EDITION.landing_page_url}
                target="_blank"
                rel="noopener noreferrer"
                className="inline-flex min-h-11 items-center justify-center gap-2 rounded-lg border border-brand-ocean px-4 py-2 text-sm font-medium text-brand-ocean hover:bg-blue-50"
              >
                Official current list <ExternalLink size={15} aria-hidden="true" />
              </a>
            </div>
            <div className="mt-4 grid gap-2 sm:grid-cols-3">
              {CURRENT_PARIS_MOU_EDITION.sources.map((source) => (
                <a
                  key={source.id}
                  href={source.url}
                  target="_blank"
                  rel="noopener noreferrer"
                  className="inline-flex min-h-11 items-center justify-between rounded-lg border border-gray-200 px-3 py-2 text-sm text-gray-700 hover:border-brand-ocean hover:text-brand-ocean"
                >
                  {STATUS_META[source.status].label} list PDF
                  <ExternalLink size={14} aria-hidden="true" />
                </a>
              ))}
            </div>
          </div>
        </Container>
      </section>

      <section className="sticky top-16 z-30 border-b border-gray-100 bg-white py-4 md:top-20" aria-label="Search and filter flag records">
        <Container>
          <div className="flex flex-col gap-3 lg:flex-row lg:items-end">
            <div className="relative flex-1">
              <label htmlFor="flag-search" className="sr-only">Search by country name or ISO code</label>
              <Search className="absolute left-3 top-1/2 -translate-y-1/2 text-gray-400" size={20} aria-hidden="true" />
              <input
                id="flag-search"
                type="search"
                placeholder="Search country or ISO code"
                value={searchTerm}
                onChange={(event) => setSearchTerm(event.target.value)}
                className="min-h-11 w-full rounded-lg border border-gray-200 py-2.5 pl-10 pr-4 focus:border-brand-ocean focus:outline-none focus:ring-2 focus:ring-brand-ocean/20"
              />
            </div>
            <fieldset className="min-w-0">
              <legend className="sr-only">Filter by Paris MoU performance status</legend>
              <div className="flex items-center gap-2">
                <Filter size={18} className="hidden shrink-0 text-gray-500 sm:block" aria-hidden="true" />
                <div className="flex max-w-full gap-2 overflow-x-auto pb-1" role="group" aria-label="Performance status">
                  {(['all', ...STATUS_ORDER] as FilterStatus[]).map((status) => {
                    const label = status === 'all' ? 'All' : STATUS_META[status].label;
                    const count = status === 'all' ? publishedFlags.length : counts[status];
                    return (
                      <button
                        key={status}
                        type="button"
                        aria-pressed={filterStatus === status}
                        onClick={() => setFilterStatus(status)}
                        className={`min-h-11 shrink-0 rounded-lg border px-3 py-2 text-sm font-medium transition-colors ${
                          filterStatus === status
                            ? 'border-brand-ocean bg-brand-ocean text-white'
                            : 'border-gray-200 bg-white text-gray-700 hover:bg-gray-50'
                        }`}
                      >
                        {label} ({count})
                      </button>
                    );
                  })}
                </div>
              </div>
            </fieldset>
          </div>
          <p className="mt-2 text-sm text-gray-600" aria-live="polite">
            Showing {filteredFlags.length} of {publishedFlags.length} records
          </p>
        </Container>
      </section>

      <section className="py-8 md:py-12" aria-label="Flag-state records">
        <Container>
          {STATUS_ORDER.map((status) => {
            const flags = groupedFlags[status];
            if (!flags.length) return null;
            const meta = STATUS_META[status];
            return (
              <section key={status} className="mb-12" aria-labelledby={`${status}-flags-heading`}>
                <h2 id={`${status}-flags-heading`} className={`mb-4 flex items-center gap-2 text-xl font-bold ${meta.headingColor}`}>
                  <span className={`h-4 w-4 shrink-0 rounded-full ${meta.dot}`} aria-hidden="true" />
                  {meta.heading} ({flags.length})
                </h2>
                <div className="grid gap-4 sm:grid-cols-2 lg:grid-cols-3">
                  {flags.map((flag, index) => <FlagCard key={flag.id} flag={flag} index={index} />)}
                </div>
              </section>
            );
          })}

          {filteredFlags.length === 0 && (
            <div className="rounded-xl border border-gray-200 bg-white py-12 text-center text-gray-500">
              No flag states match this search and filter.
            </div>
          )}

          <aside className="mt-6 rounded-xl border border-amber-200 bg-amber-50 p-4 text-sm text-amber-950 sm:p-6" aria-label="Medical information disclaimer">
            <h2 className="font-semibold">Medical information requires verification</h2>
            <p className="mt-1">
              Medical summaries are informational, may be incomplete, and are not legal or medical advice. “Needs authoritative review” means the content has not yet been signed off against current flag-specific primary sources. Confirm operational requirements with the relevant maritime authority and a qualified maritime medical supplier.
            </p>
          </aside>
        </Container>
      </section>
    </main>
  );
}

export default FlagDatabase;
