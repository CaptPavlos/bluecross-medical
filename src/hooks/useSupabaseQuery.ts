import { useState, useEffect, useCallback } from 'react';

/**
 * State shape for query operations.
 */
interface QueryState<T> {
  data: T | null;
  isLoading: boolean;
  error: string | null;
}

/**
 * Options for configuring query behavior.
 */
interface UseSupabaseQueryOptions {
  enabled?: boolean;
}

/**
 * React hook for fetching data with loading and error states.
 * Provides automatic refetching when dependencies change.
 * @param queryFn - Async function that returns the data
 * @param dependencies - Array of dependencies that trigger refetch when changed
 * @param options - Configuration options
 * @param options.enabled - Whether the query should execute (default: true)
 * @returns Query state with data, isLoading, error, and refetch function
 */
export function useSupabaseQuery<T>(
  queryFn: () => Promise<T>,
  dependencies: unknown[] = [],
  options: UseSupabaseQueryOptions = {}
): QueryState<T> & { refetch: () => Promise<void> } {
  const { enabled = true } = options;
  const [state, setState] = useState<QueryState<T>>({
    data: null,
    isLoading: true,
    error: null,
  });

  const fetchData = useCallback(async () => {
    if (!enabled) {
      setState(prev => ({ ...prev, isLoading: false }));
      return;
    }

    setState(prev => ({ ...prev, isLoading: true, error: null }));

    try {
      const result = await queryFn();
      setState({ data: result, isLoading: false, error: null });
    } catch (err) {
      const message = err instanceof Error ? err.message : 'An error occurred';
      setState({ data: null, isLoading: false, error: message });
    }
  }, [queryFn, enabled]);

  useEffect(() => {
    fetchData();
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, [...dependencies, enabled]);

  const refetch = useCallback(async () => {
    await fetchData();
  }, [fetchData]);

  return { ...state, refetch };
}

/**
 * State shape for mutation operations.
 */
interface MutationState<T> {
  data: T | null;
  isLoading: boolean;
  error: string | null;
}

/**
 * React hook for performing mutations (create, update, delete operations).
 * Provides loading state, error handling, and reset functionality.
 * @param mutationFn - Async function that performs the mutation
 * @returns Mutation state with mutate function, reset function, and state values
 */
export function useSupabaseMutation<TData, TVariables>(
  mutationFn: (variables: TVariables) => Promise<TData>
): MutationState<TData> & {
  mutate: (variables: TVariables) => Promise<TData | null>;
  reset: () => void;
} {
  const [state, setState] = useState<MutationState<TData>>({
    data: null,
    isLoading: false,
    error: null,
  });

  const mutate = useCallback(
    async (variables: TVariables): Promise<TData | null> => {
      setState({ data: null, isLoading: true, error: null });

      try {
        const result = await mutationFn(variables);
        setState({ data: result, isLoading: false, error: null });
        return result;
      } catch (err) {
        const message = err instanceof Error ? err.message : 'An error occurred';
        setState({ data: null, isLoading: false, error: message });
        return null;
      }
    },
    [mutationFn]
  );

  const reset = useCallback(() => {
    setState({ data: null, isLoading: false, error: null });
  }, []);

  return { ...state, mutate, reset };
}
