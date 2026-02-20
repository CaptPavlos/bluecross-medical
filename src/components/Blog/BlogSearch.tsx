import { useState, useMemo } from 'react';
import { Search, X } from 'lucide-react';
import { debounce } from '../../lib/utils';

/**
 * Props for the BlogSearch component.
 */
interface BlogSearchProps {
  onSearch: (query: string) => void;
  placeholder?: string;
}

/**
 * Search input component with debounced search callback.
 * Features search icon, clear button, and 300ms debounce delay.
 * @param onSearch - Callback fired with search query (debounced)
 * @param placeholder - Input placeholder text
 */
function BlogSearch({ onSearch, placeholder = 'Search articles...' }: BlogSearchProps) {
  const [value, setValue] = useState('');

  const debouncedSearch = useMemo(
    () => debounce((query: string) => {
      onSearch(query);
    }, 300),
    [onSearch]
  );

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    const newValue = e.target.value;
    setValue(newValue);
    debouncedSearch(newValue);
  };

  const handleClear = () => {
    setValue('');
    onSearch('');
  };

  return (
    <div className="relative">
      <Search
        size={18}
        className="absolute left-3 top-1/2 -translate-y-1/2 text-brand-gray"
      />
      <input
        type="text"
        value={value}
        onChange={handleChange}
        placeholder={placeholder}
        className="w-full pl-10 pr-10 py-2.5 bg-white border border-gray-200 rounded-lg text-brand-slate placeholder:text-brand-gray focus:outline-none focus:ring-2 focus:ring-brand-ocean/20 focus:border-brand-ocean transition-colors"
      />
      {value && (
        <button
          onClick={handleClear}
          className="absolute right-3 top-1/2 -translate-y-1/2 text-brand-gray hover:text-brand-slate"
          aria-label="Clear search"
        >
          <X size={16} />
        </button>
      )}
    </div>
  );
}

export default BlogSearch;
