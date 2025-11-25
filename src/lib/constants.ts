import type { NavItem, Team, Product, BlogPost, SystemStatus } from './types';

// Navigation items
export const NAV_ITEMS: NavItem[] = [
  { label: 'Flag Regulations', path: '/flags', icon: 'Flag' },
  { label: 'Training', path: '/training', icon: 'GraduationCap' },
  { label: 'Knowledge', path: '/knowledge', icon: 'BookOpen' },
  { label: 'Equipment', path: '/products', icon: 'Package' },
  { label: 'Contact', path: '/contact', icon: 'Mail' },
];

export const MOBILE_NAV_ITEMS: NavItem[] = [
  { label: 'Flags', path: '/flags', icon: 'Flag' },
  { label: 'Training', path: '/training', icon: 'GraduationCap' },
  { label: 'Equipment', path: '/products', icon: 'Package' },
  { label: 'More', path: '/menu', icon: 'Menu' },
];

// Brand colors
export const COLORS = {
  brand: {
    teal: '#06B6D4',
    tealDark: '#0891B2',
    navy: '#0F172A',
    slate: '#1E293B',
    red: '#DC2626',
    green: '#10B981',
    yellow: '#F59E0B',
    gray: '#64748B',
  },
  surface: {
    primary: '#FFFFFF',
    secondary: '#F8FAFC',
    tertiary: '#F1F5F9',
  },
};

// Status colors mapping
export const STATUS_COLORS = {
  operational: { bg: 'bg-brand-green', text: 'text-brand-green', label: 'All Systems Operational' },
  degraded: { bg: 'bg-brand-yellow', text: 'text-brand-yellow', label: 'Performance Issues' },
  maintenance: { bg: 'bg-brand-red', text: 'text-brand-red', label: 'Under Maintenance' },
};

// Product status colors
export const PRODUCT_STATUS_COLORS = {
  active: { bg: 'bg-brand-green/10', text: 'text-brand-green', border: 'border-brand-green/20' },
  beta: { bg: 'bg-brand-yellow/10', text: 'text-brand-yellow', border: 'border-brand-yellow/20' },
  deprecated: { bg: 'bg-brand-gray/10', text: 'text-brand-gray', border: 'border-brand-gray/20' },
};

// Mock data for development
export const MOCK_TEAM: Team[] = [
  {
    id: '1',
    name: 'Pavlos-Angelos Filippakis',
    role: 'Managing Director',
    bio: 'Paul founded BlueCross in Estonia in 2020, as a means to create an affordable way for owners to equip their vessels with necessary medical equipment. He is also the Captain of an expedition yacht and an active paramedic in Greece / South Africa.',
    image_url: 'https://images.spr.so/cdn-cgi/imagedelivery/j42No7y-dcokJuNgXeA0ig/5a54b920-f88c-4848-ab32-9116a792ea13/Profile_Circle_PF/w=400,quality=90,fit=scale-down',
    email: 'paul@bluecross.tech',
    social_links: {
      linkedin: 'https://linkedin.com/company/bluecross-medical',
    },
    order_index: 1,
    active: true,
    created_at: new Date().toISOString(),
    updated_at: new Date().toISOString(),
  },
  {
    id: '2',
    name: 'Athina-Ariadne Filippakis',
    role: 'CMO',
    bio: 'Athina brings her experience managing channels and running marketing campaigns from unicorn startups. She manages client relations and marketing campaigns, along with being the backbone of our CRM.',
    image_url: 'https://images.spr.so/cdn-cgi/imagedelivery/j42No7y-dcokJuNgXeA0ig/b303388a-7600-4ae5-879c-11c0f2facedc/10556465_10204238388221255_8164821583300425423_n-modified/w=400,quality=90,fit=scale-down',
    email: 'athina@bluecross.tech',
    social_links: {
      linkedin: 'https://linkedin.com/company/bluecross-medical',
    },
    order_index: 2,
    active: true,
    created_at: new Date().toISOString(),
    updated_at: new Date().toISOString(),
  },
  {
    id: '3',
    name: 'Giorgos S. Skafidas',
    role: 'COO / Co-Founder',
    bio: 'George has been in the maritime retail business for over 12 years, co-managing his family\'s marine importation business. He acts as the COO when Paul is onboard and handles the legal aspect of the business.',
    image_url: 'https://images.spr.so/cdn-cgi/imagedelivery/j42No7y-dcokJuNgXeA0ig/a7112402-d323-43a3-9851-f49725146c30/Untitled_(235__235_px)/w=400,quality=90,fit=scale-down',
    email: 'george@bluecross.tech',
    social_links: {
      linkedin: 'https://linkedin.com/company/bluecross-medical',
    },
    order_index: 3,
    active: true,
    created_at: new Date().toISOString(),
    updated_at: new Date().toISOString(),
  },
];

export const MOCK_PRODUCTS: Product[] = [
  {
    id: '1',
    name: 'Vital Signs Monitor Pro+',
    slug: 'vital-signs-monitor',
    description: 'CE approved all-in-one vital signs monitor. Includes ECG/EKG, SpO2, NIBP, Temperature, Blood Glucose - all in a device weighing just 80g.',
    long_description: 'The Checkme Pro+ Vital Signs Monitor is a pocket-sized medical device that has been tested by seafarers for years. Features a 2.7" HD touch screen, built-in rechargeable battery, and Bluetooth connectivity for iOS/Android/PC. Measures ECG with Lead I & II, SpO2 (70-100% range, ±2% accuracy), heart rate (30-250 bpm), and works with wireless blood pressure cuff. Supports 24-hour Holter monitoring and overnight sleep oxygen tracking. Free PC software and mobile apps included. CE approved with iF Design Award. 1-year warranty and lifetime support. Every purchase supports MEDICO from Hellenic Red Cross.',
    icon_name: 'Heart',
    features: ['ECG/EKG & 24hr Holter', 'SpO2 70-100%', 'Sleep Oxygen Monitor', '2.7" Touch Screen', '80g Lightweight', 'Bluetooth 4.0'],
    image_url: 'https://images.spr.so/cdn-cgi/imagedelivery/j42No7y-dcokJuNgXeA0ig/143ad6b6-6b0e-4f05-b803-c7086e8a796c/VSP_(1)/w=800,quality=90,fit=scale-down',
    ecwid_product_id: '577895719',
    status: 'available',
    order_index: 1,
    created_at: new Date().toISOString(),
    updated_at: new Date().toISOString(),
  },
  {
    id: '2',
    name: '12-Lead AI Electrocardiograph',
    slug: '12-lead-ecg',
    description: 'CE approved portable 12-lead ECG with AI analysis. 7" touch screen, WiFi transmission, detects 17+ cardiac events with 95.2% accuracy.',
    long_description: 'The Lepu Neo ECG S120 is a professional 12-lead electrocardiograph with AI-powered diagnosis. Features a 7" high-resolution color touch screen, weighs only 0.8kg, and measures 197mm x 112mm x 26mm. Supports 9 and 12-lead waveforms, automatic pacing detection, respiratory rate analysis, and HRV monitoring. AI platform trained on 50M+ data fragments detects Atrial Fibrillation, Ventricular Tachycardia, and 17+ cardiac events. Outputs PDF, DICOM, HL7, and SCP formats. WiFi and mobile network transmission. Glasgow analysis algorithm. 18-month warranty, 5-year service life. Includes lead wires, electrodes, and carrying case.',
    icon_name: 'Activity',
    features: ['12-Lead ECG', '95.2% AI Accuracy', '7" Touch Screen', '17+ Event Detection', 'WiFi Transmission', '0.8kg Portable'],
    image_url: 'https://images.spr.so/cdn-cgi/imagedelivery/j42No7y-dcokJuNgXeA0ig/26f68a92-706c-42cd-8b35-02a84c3c98d7/12-lead_Notion_Cover/w=800,quality=90,fit=scale-down',
    ecwid_product_id: '577948909',
    status: 'available',
    order_index: 2,
    created_at: new Date().toISOString(),
    updated_at: new Date().toISOString(),
  },
  {
    id: '3',
    name: 'Parsys S3 Telemedicine Station',
    slug: 'telemedicine-base-station',
    description: 'Class IIa medical device with 12-lead ECG, oximeter, BP, thermometer, glucometer, stethoscope, spirometer, and ultrasound capability.',
    long_description: 'The Parsys S3 Telemedicine Station is specifically designed for remote maritime environments. Dimensions: 475 x 376 x 178mm, weight: 9kg. Features a 15.6" LED HD touchscreen running Windows 10 Pro with MedCapture software. Includes wireless 12-lead ECG (no consumables), automatic blood pressure monitor, indestructible pulse oximeter, contactless/in-ear thermometer, glucometer, digital stethoscope, spirometer, otoscope, dermatoscope, and optional ultrasound probes. Transmission via WiFi, Ethernet, Bluetooth, or 5G. 6-hour battery with swappable lithium cells. CE 0459 marked, Class IIa medical device per MDR 2017/745. ISO 13485:2016 certified. Designed and assembled in France, deployed on hundreds of vessels worldwide.',
    icon_name: 'Monitor',
    features: ['15.6" HD Touchscreen', '12-Lead Wireless ECG', 'Digital Stethoscope', 'WiFi/5G/Bluetooth', '6hr Battery', 'CE Class IIa'],
    image_url: 'https://images.spr.so/cdn-cgi/imagedelivery/j42No7y-dcokJuNgXeA0ig/c52c8fd3-dce9-4989-a374-49cb6534f5db/Telemedicine_Base_Station_(1)/w=800,quality=90,fit=scale-down',
    ecwid_product_id: '577956229',
    status: 'available',
    order_index: 3,
    created_at: new Date().toISOString(),
    updated_at: new Date().toISOString(),
  },
  {
    id: '4',
    name: 'HeartSine Samaritan PAD 500P',
    slug: 'semi-automatic-defibrillator',
    description: 'Semi-automatic AED with real-time CPR feedback. IP56 rated, 1.1kg, 8-year warranty - the longest in the industry.',
    long_description: 'The HeartSine Samaritan PAD 500P is a semi-automatic defibrillator with integrated CPR Advisor™ technology. Provides real-time visual and verbal feedback on compression depth and rate through the defibrillation pads - no accelerometer pucks needed. Voice prompts guide rescuers with "Push Harder" or "Good Compressions" based on actual cardiac output. IP56 rated for dust and moisture resistance, weighs only 1.1kg. Lowest total cost of ownership - combined Pad-Pak (electrodes + battery) replaced only every 4 years. Semi-automatic operation prevents accidental shocks with untrained personnel. Can increase survival chance for witnessed cardiac arrest up to 85%. 8-year warranty - longest in the industry. CE and FDA approved. Made in EU (Northern Ireland). Every purchase supports MEDICO from Hellenic Red Cross.',
    icon_name: 'Zap',
    features: ['CPR Advisor™ Feedback', '8-Year Warranty', 'IP56 Dust/Moisture', '1.1kg Lightweight', '4-Year Pad-Pak', 'Made in EU'],
    image_url: 'https://images.spr.so/cdn-cgi/imagedelivery/j42No7y-dcokJuNgXeA0ig/7f19e4a7-df0b-4bca-abee-453050f6f9fb/DeFib_Notion_Cover/w=800,quality=90,fit=scale-down',
    ecwid_product_id: '578004034',
    status: 'available',
    order_index: 4,
    created_at: new Date().toISOString(),
    updated_at: new Date().toISOString(),
  },
  {
    id: '5',
    name: 'Oxygen Resuscitation Kit',
    slug: 'oxygen-resuscitation-kit',
    description: 'Complete MCA/SOLAS compliant oxygen therapy kit with cylinder, regulator, BVM, and masks for maritime emergency use.',
    long_description: 'Professional oxygen resuscitation kit designed for maritime use and compliant with MCA MSN 1768 and SOLAS requirements. Includes: 2L or 5L aluminum oxygen cylinder (lightweight, corrosion-resistant), adjustable flow regulator (0-15 L/min), adult and pediatric bag valve masks (BVM), oxygen masks with reservoir bags, nasal cannulas, suction device, oropharyngeal airways (sizes 0-5), and durable carry case. Cylinder pressure gauge and flow indicator included. Essential for respiratory emergencies, drowning recovery, smoke inhalation, and cardiac events. Annual inspection certificate provided. Spare cylinders and consumables available.',
    icon_name: 'Wind',
    features: ['MCA/SOLAS Compliant', '2L or 5L Cylinder', 'Adult & Pediatric BVM', '0-15 L/min Regulator', 'Corrosion Resistant', 'Annual Inspection'],
    image_url: 'https://images.spr.so/cdn-cgi/imagedelivery/j42No7y-dcokJuNgXeA0ig/24552e5d-9512-467b-a55a-86f6892cf0ab/Oxygen_Resuscitation_Kit_-_Notion_Cover_(1)/w=800,quality=90,fit=scale-down',
    status: 'not-available',
    order_index: 5,
    created_at: new Date().toISOString(),
    updated_at: new Date().toISOString(),
  },
  {
    id: '6',
    name: 'Tactical Bleeding Control Kit',
    slug: 'bleeding-control-kit',
    description: 'TCCC-compliant trauma kit with CAT tourniquet, hemostatic gauze, chest seals, and pressure bandages for severe hemorrhage control.',
    long_description: 'Professional bleeding control kit based on Tactical Combat Casualty Care (TCCC) guidelines. Contents: CAT Gen 7 tourniquet (Combat Application Tourniquet), QuikClot Combat Gauze (hemostatic agent), HyFin Vent chest seals (twin pack for entry/exit wounds), Israeli Emergency Bandage (6"), compressed gauze, NPA with lubricant, trauma shears, nitrile gloves, and permanent marker. All items vacuum-sealed in waterproof pouch. Designed for maritime emergency response - treats penetrating trauma, amputations, and severe lacerations. Training guide included with QR code to video tutorials. Compact design fits in bridge emergency station or tender. 3-year shelf life on hemostatic agents.',
    icon_name: 'Shield',
    features: ['CAT Gen 7 Tourniquet', 'QuikClot Hemostatic', 'HyFin Chest Seals', 'Israeli Bandage', 'TCCC Guidelines', 'Waterproof Pouch'],
    image_url: 'https://images.spr.so/cdn-cgi/imagedelivery/j42No7y-dcokJuNgXeA0ig/01628833-765e-492a-92a1-dcd3d4b6dc01/Bleeding_Control_Kit_Notion_Cover/w=800,quality=90,fit=scale-down',
    status: 'not-available',
    order_index: 6,
    created_at: new Date().toISOString(),
    updated_at: new Date().toISOString(),
  },
];

export const MOCK_BLOG_POSTS: BlogPost[] = [
  {
    id: '1',
    title: 'What is the M.A.C. and why it matters?',
    slug: 'what-is-the-mac-and-why-it-matters',
    content: 'Medical Advice Center (MAC) of Hellenic Red Cross was established by law in November 1987 and is included in the network of total five (5) Medical Advice Centers established in France, Italy, Greece, Spain and Portugal. The Greek Center moved to Henry Dunant Hospital in 2009.\n\nMAC operates on a 24/7 basis, with the direct support of Henry Dunant Hospital\'s doctors, offering medical advice to any emergency that may occur to passengers and crews onboard commercial or other vessels in all seas around the world, without distinction on the flag ship or nationality.\n\nIn 34 years of operation, MAC\'s work has been recognized by sailors and based on the high levels of services offered naval family has developed absolute confidence.\n\nCapabilities of MAC include:\n- Direct telephone communication from anywhere in the world via satellite, coastal telecommunications network "Olympia Radio" or Hellenic Coast Guard Operation Center.\n- Image Transfer via Internet (e-mail) for more complete information of Physicians, direct and easier response to incidents.\n- Response to incidents (injuries, minor illnesses, minor burns etc.) taking into account the limitation of the pharmaceutical and hospital instruments of ships.\n- For incidents that cannot be addressed on board, relevant advice is given to the master in order to make diversion of the ship to the nearest port.\n\nEmergency numbers: +30 210 523 0880 / +30 210 523 7515\n\nSafe seas!',
    excerpt: 'Medical Advice Center (MAC) of Hellenic Red Cross operates 24/7, offering medical advice to any emergency onboard vessels worldwide.',
    featured_image_url: 'https://images.spr.so/cdn-cgi/imagedelivery/j42No7y-dcokJuNgXeA0ig/c06cac5e-9405-449f-82f6-dbf89c591715/MAC_Blog_Cover/w=800,quality=90,fit=scale-down',
    author_name: 'BlueCross Medical',
    published: true,
    published_at: '2024-01-15T10:00:00Z',
    tags: ['MAC', 'Hellenic Red Cross', 'Emergency', 'Maritime'],
    reading_time_minutes: 4,
    created_at: new Date().toISOString(),
    updated_at: new Date().toISOString(),
  },
  {
    id: '2',
    title: 'What medicines can be found in a ship\'s medical chest?',
    slug: 'ships-medical-chest-medicines',
    content: 'Every ship in the world carries an inventory of medicines (termed "medical chest"). What is inside that inventory depends on the regulations of each vessel\'s Flag state. Usually, there is a distinction between ocean-going vessels and vessels that sail closer to the coast.\n\nThis list is not exclusive and many companies decide to add additional equipment through their company\'s ISM. After all, you will notice that vital items such as a defibrillator or telemedicine monitor are absent from the "required" list.\n\nUsually, the lists are split into 3 parts:\n\n1. Narcotics - These medicines are deemed "narcotics" by the Flag state and have to be kept in the custody of the Master, locked away from the rest of the medicine chest.\n\n2. Normal medicines - Usually stored in the ship\'s hospital or medical chest.\n\n3. Paramedics and equipment - Various equipment that the vessel needs to have.\n\nMedicine Chest Regulations vary by Flag state including Greece, Malta, Cyprus, United Kingdom, Bermuda, Cayman Islands, Marshall Islands, Liberia, and Panama.',
    excerpt: 'Every ship carries a medical chest. Learn what medicines are required by different Flag states and how to maintain compliance.',
    featured_image_url: 'https://images.spr.so/cdn-cgi/imagedelivery/j42No7y-dcokJuNgXeA0ig/fbdb23ed-2e95-45ef-bd67-f445c387c3b1/What_medicines_can_be_found_in_a_ships_medical_chest/w=800,quality=90,fit=scale-down',
    author_name: 'BlueCross Medical',
    published: true,
    published_at: '2024-01-10T14:00:00Z',
    tags: ['Medical Chest', 'Regulations', 'Maritime', 'Flag State'],
    reading_time_minutes: 5,
    created_at: new Date().toISOString(),
    updated_at: new Date().toISOString(),
  },
  {
    id: '3',
    title: 'Why Every Vessel Needs a Defibrillator',
    slug: 'why-every-vessel-needs-defibrillator',
    content: 'Investing in an AED is a giant step forward because it can increase the chance of survival for witnessed Cardiac Arrest up to 85%.\n\nNot investing in an AED means that in case of a cardiac arrest, when in the high seas, most likely the crew member will die as it not humanly possible to continue CPR indefinitely.\n\nAbout 70% of all CPR is ineffectively performed, so devices like the HeartSine Samaritan 500P Defibrillator contain technology that determines whether your compressions are effective. Voice prompts guide you through the process and tell you to "Push Harder" or whether you are doing "Good Compressions" during CPR – all based on real cardiac output.\n\nKey benefits of the HeartSine 500P:\n- 8-year warranty - longest in the industry\n- Real-time CPR Feedback\n- Lowest maintenance cost - pads and battery renewed only every 4 years\n- IP56 rated for dust & moisture\n- Lightweight at only 1.1kg\n- Made in EU',
    excerpt: 'An AED can increase survival chances for cardiac arrest up to 85%. Learn why every vessel should have one onboard.',
    featured_image_url: 'https://images.spr.so/cdn-cgi/imagedelivery/j42No7y-dcokJuNgXeA0ig/7f19e4a7-df0b-4bca-abee-453050f6f9fb/DeFib_Notion_Cover/w=800,quality=90,fit=scale-down',
    author_name: 'BlueCross Medical',
    published: true,
    published_at: '2024-01-05T09:00:00Z',
    tags: ['Defibrillator', 'AED', 'CPR', 'Safety', 'Maritime'],
    reading_time_minutes: 4,
    created_at: new Date().toISOString(),
    updated_at: new Date().toISOString(),
  },
  {
    id: '4',
    title: 'The Importance of Remote ECG Monitoring at Sea',
    slug: 'importance-remote-ecg-monitoring-sea',
    content: 'Heart disease remains one of the leading causes of death among seafarers. With crew members often working in high-stress environments, far from medical facilities, early detection of cardiac issues is critical.\n\nModern ECG devices like our 12-lead AI Electrocardiographer can detect over 17 types of cardiac events including Atrial Fibrillation, Ventricular Tachycardia, and other arrhythmias. With 95.2% AI accuracy trained on over 50 million data fragments, these devices provide medical-grade reports that can be transmitted remotely to shore-based physicians.\n\nKey advantages of remote ECG monitoring:\n- Early detection of cardiac abnormalities\n- AI-powered analysis for immediate insights\n- Remote transmission to medical professionals\n- Holter monitoring capability for 24-hour assessments\n- Lightweight and portable design perfect for maritime use',
    excerpt: 'Early detection of cardiac issues at sea can save lives. Learn how modern ECG devices are transforming maritime healthcare.',
    featured_image_url: 'https://images.spr.so/cdn-cgi/imagedelivery/j42No7y-dcokJuNgXeA0ig/26f68a92-706c-42cd-8b35-02a84c3c98d7/12-lead_Notion_Cover/w=800,quality=90,fit=scale-down',
    author_name: 'BlueCross Medical',
    published: true,
    published_at: '2024-01-02T10:00:00Z',
    tags: ['ECG', 'Heart Health', 'Telemedicine', 'Maritime', 'AI'],
    reading_time_minutes: 5,
    created_at: new Date().toISOString(),
    updated_at: new Date().toISOString(),
  },
  {
    id: '5',
    title: 'Telemedicine at Sea: The Future of Maritime Healthcare',
    slug: 'telemedicine-at-sea-future-maritime-healthcare',
    content: 'The maritime industry is experiencing a healthcare revolution with the adoption of advanced telemedicine systems. The S3 Base Station represents the most advanced telemedicine solution specifically designed for remote maritime environments.\n\nFeatures that make modern telemedicine essential:\n- Works offline and transmits via low bandwidth systems like FBB\n- Patented pad-free ECG technology for quick readings\n- HIPAA/HDS compliant data storage\n- Integration with 24/7 medical advice centers\n- Digital stethoscope for remote respiratory assessment\n\nWith proper telemedicine equipment, vessels can connect with shore-based physicians in real-time, ensuring crew members receive expert medical guidance regardless of their location at sea.',
    excerpt: 'Modern telemedicine systems are revolutionizing healthcare delivery at sea. Discover the latest in maritime medical technology.',
    featured_image_url: 'https://images.spr.so/cdn-cgi/imagedelivery/j42No7y-dcokJuNgXeA0ig/c52c8fd3-dce9-4989-a374-49cb6534f5db/Telemedicine_Base_Station_(1)/w=800,quality=90,fit=scale-down',
    author_name: 'BlueCross Medical',
    published: true,
    published_at: '2023-12-28T14:00:00Z',
    tags: ['Telemedicine', 'Maritime', 'Technology', 'Healthcare', 'Remote'],
    reading_time_minutes: 6,
    created_at: new Date().toISOString(),
    updated_at: new Date().toISOString(),
  },
  {
    id: '6',
    title: 'Captain Richard\'s Story: Why Crew Health Monitoring Matters',
    slug: 'captain-richards-story-crew-health-monitoring',
    content: 'Imagine Captain Richard - 20 years with your fleet, mid-fifties, two packs a day. He is currently alongside a port in China during Covid measures. At 08:00 LT, he is found unconscious and without a pulse. There is no defibrillator on board.\n\nThis scenario, while extreme, highlights the reality many shipping companies face. Heart disease is a leading cause of death at sea, and preventive monitoring can make the difference between life and death.\n\nWhat if Captain Richard had access to weekly ECG monitoring through a portable Vital Signs Pro+ device? The early warning signs of cardiac issues could have been detected and addressed before a crisis occurred.\n\nKey takeaways:\n- High-risk crew members need regular monitoring\n- Portable devices make monitoring feasible at sea\n- Early detection saves lives and reduces costs\n- P&I clubs increasingly recognize the value of preventive care',
    excerpt: 'A fictional but realistic scenario that illustrates the life-saving importance of crew health monitoring at sea.',
    featured_image_url: 'https://images.spr.so/cdn-cgi/imagedelivery/j42No7y-dcokJuNgXeA0ig/143ad6b6-6b0e-4f05-b803-c7086e8a796c/VSP_(1)/w=800,quality=90,fit=scale-down',
    author_name: 'BlueCross Medical',
    published: true,
    published_at: '2023-12-20T09:00:00Z',
    tags: ['Crew Health', 'Prevention', 'Maritime', 'Safety', 'Case Study'],
    reading_time_minutes: 5,
    created_at: new Date().toISOString(),
    updated_at: new Date().toISOString(),
  },
];

export const MOCK_SYSTEM_STATUS: SystemStatus = {
  id: '1',
  status: 'operational',
  message: 'All systems are running smoothly.',
  severity: 0,
  updated_at: new Date().toISOString(),
};

// Tech stack items
export const TECH_STACK = [
  { name: 'React', category: 'Frontend', icon: 'Code2' },
  { name: 'TypeScript', category: 'Language', icon: 'FileCode' },
  { name: 'Node.js', category: 'Backend', icon: 'Server' },
  { name: 'PostgreSQL', category: 'Database', icon: 'Database' },
  { name: 'Supabase', category: 'Platform', icon: 'Cloud' },
  { name: 'Tailwind CSS', category: 'Styling', icon: 'Palette' },
  { name: 'Vercel', category: 'Hosting', icon: 'Globe' },
  { name: 'HIPAA', category: 'Compliance', icon: 'Shield' },
];

// Company info
export const COMPANY_INFO = {
  name: 'BlueCross Medical',
  tagline: 'Maritime Emergency Medicine',
  description: 'Your complete resource for emergency medicine at sea. Flag state regulations, advanced training courses, knowledge articles, and tested equipment - all in one place.',
  email: 'sales@bluecross.tech',
  phone: '+30 698 672 0525',
  emergencyPhone: '+30 210 523 0880',
  address: 'Frynis 55, Athens, Greece',
  workingHours: 'Mon-Fri 09:00 - 18:00 (EET/EEST)',
  social: {
    linkedin: 'https://linkedin.com/company/bluecross-medical',
    twitter: '#',
    facebook: '#',
  },
};

// API timeout
export const API_TIMEOUT = 30000;
