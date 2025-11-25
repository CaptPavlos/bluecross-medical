// Core TypeScript interfaces for BlueCross Medical

export interface Team {
  id: string;
  name: string;
  role: string;
  bio?: string;
  image_url?: string;
  email?: string;
  social_links?: SocialLinks;
  order_index: number;
  active: boolean;
  created_at: string;
  updated_at: string;
}

export interface SocialLinks {
  linkedin?: string;
  twitter?: string;
  github?: string;
}

export interface Product {
  id: string;
  name: string;
  slug: string;
  description: string;
  long_description?: string;
  icon_name?: string;
  features: string[];
  status: ProductStatus;
  image_url?: string;
  ecwid_product_id?: string;
  order_index: number;
  created_at: string;
  updated_at: string;
}

export type ProductStatus = 'available' | 'not-available';

export interface BlogPost {
  id: string;
  title: string;
  slug: string;
  content: string;
  excerpt: string;
  featured_image_url?: string;
  author_id?: string;
  author_name: string;
  published: boolean;
  published_at?: string;
  tags: string[];
  reading_time_minutes?: number;
  created_at: string;
  updated_at: string;
}

export interface TMASContact {
  name: string;
  phone: string;
  email?: string;
  website?: string;
  hours: string; // e.g., "24/7"
  languages?: string[];
  notes?: string;
}

export interface YachtRequirements {
  applicable: boolean; // Whether special yacht regulations exist
  code_name?: string; // e.g., "LY3", "REG Yachting"
  min_length_meters?: number; // Minimum yacht length for requirements
  categories?: string[]; // e.g., ["Commercial Yacht", "Private Yacht"]
  differences_from_commercial?: string[];
  medical_personnel_required?: boolean;
  doctor_required_passengers?: number; // Number of passengers requiring onboard doctor
}

export interface EquipmentDifferences {
  aed_required: boolean;
  aed_recommendation?: string; // e.g., "Strongly recommended", "Required for passenger vessels"
  oxygen_equipment_required: boolean;
  antidote_kit_required?: boolean; // For chemical/tanker vessels
  stretcher_required?: boolean;
  additional_equipment?: string[];
  who_guide_deviations?: string[]; // Differences from WHO International Medical Guide
}

export interface FlagState {
  id: string;
  country_name: string;
  country_code: string; // ISO 3166-1 alpha-2
  flag_emoji: string;
  paris_mou_status: 'white' | 'grey' | 'black';
  paris_mou_rank?: number;
  slug: string;
  content: string;
  excerpt: string;
  medical_categories: string[]; // A, B, C categories
  key_requirements: string[];
  inspection_interval_months: number;
  maritime_authority: string;
  authority_website?: string;
  // Enhanced fields
  tmas?: TMASContact;
  yacht_requirements?: YachtRequirements;
  equipment_differences?: EquipmentDifferences;
  published: boolean;
  created_at: string;
  updated_at: string;
}

export interface ContactSubmission {
  name: string;
  email: string;
  subject: string;
  message: string;
}

export interface SystemStatus {
  id: string;
  status: SystemStatusType;
  message?: string;
  severity: number;
  updated_at: string;
}

export type SystemStatusType = 'operational' | 'degraded' | 'maintenance';

// API Response types
export interface ApiResponse<T> {
  data: T | null;
  error: ApiError | null;
}

export interface ApiError {
  message: string;
  code?: string;
}

// Form states
export interface FormState {
  isSubmitting: boolean;
  isSuccess: boolean;
  error: string | null;
}

// Navigation types
export interface NavItem {
  label: string;
  path: string;
  icon?: string;
}

// Component prop types
export interface BaseComponentProps {
  className?: string;
  children?: React.ReactNode;
}

export interface LoadingState {
  isLoading: boolean;
  error: string | null;
}
