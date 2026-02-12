/* eslint-disable react-refresh/only-export-components */
import { createContext, useContext, useState, ReactNode } from 'react';

/**
 * Shape of the authentication context value.
 */
interface AuthContextType {
  isAdmin: boolean;
  login: (username: string, password: string) => boolean;
  logout: () => void;
}

const AuthContext = createContext<AuthContextType | undefined>(undefined);

/** Admin username for authentication (use proper auth in production) */
const ADMIN_USERNAME = 'dev@marsoft.ai';
/** Admin password for authentication (use proper auth in production) */
const ADMIN_PASSWORD = 'Admin';

/**
 * Authentication provider component that manages admin login state.
 * Persists login state to localStorage for session persistence.
 * @param children - Child components that need access to auth context
 */
export function AuthProvider({ children }: { children: ReactNode }) {
  // Initialize state from localStorage
  const [isAdmin, setIsAdmin] = useState(() => {
    const adminLoggedIn = localStorage.getItem('bluecross_admin');
    return adminLoggedIn === 'true';
  });

  const login = (username: string, password: string): boolean => {
    if (username === ADMIN_USERNAME && password === ADMIN_PASSWORD) {
      setIsAdmin(true);
      localStorage.setItem('bluecross_admin', 'true');
      return true;
    }
    return false;
  };

  const logout = () => {
    setIsAdmin(false);
    localStorage.removeItem('bluecross_admin');
  };

  return (
    <AuthContext.Provider value={{ isAdmin, login, logout }}>
      {children}
    </AuthContext.Provider>
  );
}

/**
 * Hook to access authentication context.
 * Must be used within an AuthProvider.
 * @returns Auth context with isAdmin state, login, and logout functions
 * @throws Error if used outside of AuthProvider
 */
export function useAuth() {
  const context = useContext(AuthContext);
  if (context === undefined) {
    throw new Error('useAuth must be used within an AuthProvider');
  }
  return context;
}
