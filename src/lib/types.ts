/**
 * @fileoverview Core TypeScript interfaces and types for BlueCross Medical.
 * Defines data structures for teams, products, blog posts, and flag states.
 */

/**
 * Team member profile data.
 */
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

/**
 * Social media profile links for team members.
 */
export interface SocialLinks {
  linkedin?: string;
  twitter?: string;
  github?: string;
}

/**
 * Medical product or equipment data.
 */
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
  price?: number;
  order_index: number;
  created_at: string;
  updated_at: string;
}

/** Product availability status */
export type ProductStatus = 'in-stock' | 'to-order' | 'not-available';

/**
 * Blog post or knowledge article data.
 */
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

/**
 * Telemedical Maritime Assistance Service (TMAS) contact information.
 */
export interface TMASContact {
  name: string;
  phone: string;
  email?: string;
  website?: string;
  hours: string; // e.g., "24/7"
  languages?: string[];
  notes?: string;
}

/**
 * Yacht-specific medical requirements for a flag state.
 */
export interface YachtRequirements {
  applicable: boolean; // Whether special yacht regulations exist
  code_name?: string; // e.g., "LY3", "REG Yachting"
  min_length_meters?: number; // Minimum yacht length for requirements
  categories?: string[]; // e.g., ["Commercial Yacht", "Private Yacht"]
  differences_from_commercial?: string[];
  medical_personnel_required?: boolean;
  doctor_required_passengers?: number; // Number of passengers requiring onboard doctor
}

/**
 * Flag state differences from standard WHO medical equipment guidelines.
 */
export interface EquipmentDifferences {
  aed_required: boolean;
  aed_recommendation?: string; // e.g., "Strongly recommended", "Required for passenger vessels"
  oxygen_equipment_required: boolean;
  antidote_kit_required?: boolean; // For chemical/tanker vessels
  stretcher_required?: boolean;
  additional_equipment?: string[];
  who_guide_deviations?: string[]; // Differences from WHO International Medical Guide
}

/** Paris MoU performance band for the current edition. */
export type ParisMouStatus = 'white' | 'grey' | 'black' | 'not-listed';

/** Human review state for flag-specific medical guidance. */
export type MedicalReviewStatus = 'reviewed' | 'needs-authoritative-review';

/** A source used to review a flag-specific medical regulation summary. */
export interface MedicalRegulationSource {
  title: string;
  url: string;
  authority?: string;
  checked_on?: string | null;
}

/**
 * Maritime flag state with medical regulations and requirements.
 */
export interface FlagState {
  id: string;
  country_name: string;
  country_code: string; // ISO 3166-1 alpha-2
  flag_emoji: string;
  paris_mou_status: ParisMouStatus;
  /** Global rank in the current Paris MoU edition; null when not listed. */
  paris_mou_rank: number | null;
  paris_mou_edition: number;
  paris_mou_valid_from: string;
  paris_mou_valid_until: string;
  paris_mou_inspections: number | null;
  paris_mou_detentions: number | null;
  paris_mou_source_url: string;
  slug: string;
  content: string;
  excerpt: string;
  medical_categories: string[] | null; // Null means not yet authoritatively established.
  key_requirements: string[];
  inspection_interval_months: number | null;
  maritime_authority: string | null;
  authority_website?: string;
  medical_review_status: MedicalReviewStatus;
  medical_reviewed_on: string | null;
  medical_sources: MedicalRegulationSource[];
  medical_disclaimer: string;
  // Enhanced fields
  tmas?: TMASContact;
  yacht_requirements?: YachtRequirements;
  equipment_differences?: EquipmentDifferences;
  published: boolean;
  created_at: string | null;
  updated_at: string | null;
}

/**
 * Contact form submission data.
 */
export interface ContactSubmission {
  name: string;
  email: string;
  subject: string;
  message: string;
}

/**
 * System operational status data.
 */
export interface SystemStatus {
  id: string;
  status: SystemStatusType;
  message?: string;
  severity: number;
  updated_at: string;
}

/** System status type values */
export type SystemStatusType = 'operational' | 'degraded' | 'maintenance';

/**
 * Generic API response wrapper with data and error.
 */
export interface ApiResponse<T> {
  data: T | null;
  error: ApiError | null;
}

/**
 * API error response structure.
 */
export interface ApiError {
  message: string;
  code?: string;
}

/**
 * Common form state for submission handling.
 */
export interface FormState {
  isSubmitting: boolean;
  isSuccess: boolean;
  error: string | null;
}

/**
 * Navigation menu item structure.
 */
export interface NavItem {
  label: string;
  path: string;
  icon?: string;
}

/**
 * Base props shared by most components.
 */
export interface BaseComponentProps {
  className?: string;
  children?: React.ReactNode;
}

/**
 * Common loading state for async operations.
 */
export interface LoadingState {
  isLoading: boolean;
  error: string | null;
}
