import { useState, useMemo } from 'react';
import { Link } from 'react-router-dom';
import { motion } from 'framer-motion';
import { Search, Filter, ChevronRight } from 'lucide-react';
import Container from '../components/Common/Container';
import { FLAG_STATES } from '../lib/flagStates';
import type { FlagState } from '../lib/types';

type FilterStatus = 'all' | 'white' | 'grey' | 'black';

function FlagDatabase() {
  const [searchTerm, setSearchTerm] = useState('');
  const [filterStatus, setFilterStatus] = useState<FilterStatus>('all');

  const filteredFlags = useMemo(() => {
    return FLAG_STATES.filter((flag) => {
      const matchesSearch = flag.country_name.toLowerCase().includes(searchTerm.toLowerCase()) ||
        flag.country_code.toLowerCase().includes(searchTerm.toLowerCase());
      const matchesFilter = filterStatus === 'all' || flag.paris_mou_status === filterStatus;
      return matchesSearch && matchesFilter && flag.published;
    });
  }, [searchTerm, filterStatus]);

  const whiteList = filteredFlags.filter(f => f.paris_mou_status === 'white');
  const greyList = filteredFlags.filter(f => f.paris_mou_status === 'grey');
  const blackList = filteredFlags.filter(f => f.paris_mou_status === 'black');

  const statusColors = {
    white: 'bg-green-100 text-green-800 border-green-200',
    grey: 'bg-yellow-100 text-yellow-800 border-yellow-200',
    black: 'bg-red-100 text-red-800 border-red-200',
  };

  const FlagCard = ({ flag, index }: { flag: FlagState; index: number }) => (
    <motion.div
      initial={{ opacity: 0, y: 20 }}
      animate={{ opacity: 1, y: 0 }}
      transition={{ delay: index * 0.05 }}
    >
      <Link to={`/flags/${flag.slug}`}>
        <div className="bg-white rounded-xl border border-gray-200 p-4 hover:shadow-lg hover:border-brand-ocean/30 transition-all group">
          <div className="flex items-start gap-4">
            <span className="text-4xl">{flag.flag_emoji}</span>
            <div className="flex-1 min-w-0">
              <div className="flex items-center gap-2 mb-1">
                <h3 className="font-semibold text-brand-navy group-hover:text-brand-ocean transition-colors">
                  {flag.country_name}
                </h3>
                <span className={`text-xs px-2 py-0.5 rounded-full border ${statusColors[flag.paris_mou_status]}`}>
                  {flag.paris_mou_status.toUpperCase()}
                  {flag.paris_mou_rank && ` #${flag.paris_mou_rank}`}
                </span>
              </div>
              <p className="text-sm text-brand-gray line-clamp-2">{flag.excerpt}</p>
              <div className="flex items-center gap-2 mt-2 text-xs text-brand-ocean">
                <span>View requirements</span>
                <ChevronRight size={14} className="group-hover:translate-x-1 transition-transform" />
              </div>
            </div>
          </div>
        </div>
      </Link>
    </motion.div>
  );

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
            <h1 className="text-3xl md:text-4xl font-bold text-white mb-4">
              🌍 Flag Regulations
            </h1>
            <p className="text-lg text-brand-sky-light max-w-2xl mx-auto">
              Comprehensive database of maritime medical regulations by flag state.
              Browse requirements, TMAS contacts, and compliance guidance.
            </p>
          </motion.div>
        </Container>
      </section>

      {/* Search & Filter */}
      <section className="py-6 border-b border-gray-100 bg-white sticky top-16 md:top-20 z-30">
        <Container>
          <div className="flex flex-col md:flex-row gap-4">
            <div className="relative flex-1">
              <Search className="absolute left-3 top-1/2 -translate-y-1/2 text-gray-400" size={20} />
              <input
                type="text"
                placeholder="Search by country name or code..."
                value={searchTerm}
                onChange={(e) => setSearchTerm(e.target.value)}
                className="w-full pl-10 pr-4 py-2.5 border border-gray-200 rounded-lg focus:outline-none focus:ring-2 focus:ring-brand-ocean/20 focus:border-brand-ocean"
              />
            </div>
            <div className="flex items-center gap-2">
              <Filter size={18} className="text-gray-500" />
              <div className="flex rounded-lg border border-gray-200 overflow-hidden">
                {(['all', 'white', 'grey', 'black'] as FilterStatus[]).map((status) => (
                  <button
                    key={status}
                    onClick={() => setFilterStatus(status)}
                    className={`px-4 py-2 text-sm font-medium transition-colors ${
                      filterStatus === status
                        ? 'bg-brand-ocean text-white'
                        : 'bg-white text-gray-600 hover:bg-gray-50'
                    }`}
                  >
                    {status === 'all' ? 'All' : status.charAt(0).toUpperCase() + status.slice(1)}
                  </button>
                ))}
              </div>
            </div>
          </div>
          <div className="mt-4 flex gap-4 text-sm text-gray-600">
            <span className="flex items-center gap-1">
              <span className="w-3 h-3 rounded-full bg-green-500"></span>
              White List ({whiteList.length})
            </span>
            <span className="flex items-center gap-1">
              <span className="w-3 h-3 rounded-full bg-yellow-500"></span>
              Grey List ({greyList.length})
            </span>
            <span className="flex items-center gap-1">
              <span className="w-3 h-3 rounded-full bg-red-500"></span>
              Black List ({blackList.length})
            </span>
          </div>
        </Container>
      </section>

      {/* Flag Lists */}
      <section className="py-8 md:py-12">
        <Container>
          {filterStatus === 'all' || filterStatus === 'white' ? (
            whiteList.length > 0 && (
              <div className="mb-12">
                <h2 className="text-xl font-bold text-green-700 mb-4 flex items-center gap-2">
                  <span className="w-4 h-4 rounded-full bg-green-500"></span>
                  White List - Quality Flags
                </h2>
                <div className="grid sm:grid-cols-2 lg:grid-cols-3 gap-4">
                  {whiteList.map((flag, i) => (
                    <FlagCard key={flag.id} flag={flag} index={i} />
                  ))}
                </div>
              </div>
            )
          ) : null}

          {filterStatus === 'all' || filterStatus === 'grey' ? (
            greyList.length > 0 && (
              <div className="mb-12">
                <h2 className="text-xl font-bold text-yellow-700 mb-4 flex items-center gap-2">
                  <span className="w-4 h-4 rounded-full bg-yellow-500"></span>
                  Grey List - Average Performance
                </h2>
                <div className="grid sm:grid-cols-2 lg:grid-cols-3 gap-4">
                  {greyList.map((flag, i) => (
                    <FlagCard key={flag.id} flag={flag} index={i} />
                  ))}
                </div>
              </div>
            )
          ) : null}

          {filterStatus === 'all' || filterStatus === 'black' ? (
            blackList.length > 0 && (
              <div className="mb-12">
                <h2 className="text-xl font-bold text-red-700 mb-4 flex items-center gap-2">
                  <span className="w-4 h-4 rounded-full bg-red-500"></span>
                  Black List - High Risk
                </h2>
                <div className="grid sm:grid-cols-2 lg:grid-cols-3 gap-4">
                  {blackList.map((flag, i) => (
                    <FlagCard key={flag.id} flag={flag} index={i} />
                  ))}
                </div>
              </div>
            )
          ) : null}

          {filteredFlags.length === 0 && (
            <div className="text-center py-12 text-gray-500">
              No flag states found matching your search.
            </div>
          )}
        </Container>
      </section>

      {/* Info Section */}
      <section className="py-8 bg-surface-secondary">
        <Container>
          <div className="bg-white rounded-xl p-6 border border-gray-200">
            <h3 className="font-semibold text-brand-navy mb-2">📊 Paris MOU 2024 Performance Lists</h3>
            <p className="text-sm text-gray-600 mb-4">
              The Paris MOU White, Grey and Black lists rank flag states based on port state control 
              inspection performance over a 3-year rolling period (2022-2024). Valid from 1 July 2025 to 30 June 2026.
            </p>
            <div className="grid sm:grid-cols-3 gap-3 mb-4">
              <a 
                href="https://parismou.org/system/files/2025-06/Paris%20MoU%20White%20List%202024.pdf"
                target="_blank"
                rel="noopener noreferrer"
                className="flex items-center gap-2 px-3 py-2 bg-green-50 border border-green-200 rounded-lg text-sm text-green-700 hover:bg-green-100 transition-colors"
              >
                📄 White List 2024 (PDF)
              </a>
              <a 
                href="https://parismou.org/system/files/2025-06/Paris%20MoU%20Grey%20List%202024.pdf"
                target="_blank"
                rel="noopener noreferrer"
                className="flex items-center gap-2 px-3 py-2 bg-yellow-50 border border-yellow-200 rounded-lg text-sm text-yellow-700 hover:bg-yellow-100 transition-colors"
              >
                📄 Grey List 2024 (PDF)
              </a>
              <a 
                href="https://parismou.org/system/files/2025-06/Paris%20MoU%20Black%20List%202024.pdf"
                target="_blank"
                rel="noopener noreferrer"
                className="flex items-center gap-2 px-3 py-2 bg-red-50 border border-red-200 rounded-lg text-sm text-red-700 hover:bg-red-100 transition-colors"
              >
                📄 Black List 2024 (PDF)
              </a>
            </div>
            <p className="text-xs text-gray-500">
              2024 Statistics: 40 White List, 17 Grey List, 12 Black List (69 total flag states). 
              France ranked #1 (up from #11), Denmark #2, Norway #3.
            </p>
          </div>
        </Container>
      </section>
    </main>
  );
}

export default FlagDatabase;
