import { useState, useEffect, useCallback } from 'react';

interface QueryState<T> {
  data: T | null;
  isLoading: boolean;
  error: string | null;
}

interface UseSupabaseQueryOptions {
  enabled?: boolean;
}

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

// Simplified mutation hook
interface MutationState<T> {
  data: T | null;
  isLoading: boolean;
  error: string | null;
}

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
