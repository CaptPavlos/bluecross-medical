import type { FlagState, TMASContact } from './types';

// TMAS Contact Directory (Telemedical Maritime Assistance Services)
export const TMAS_DIRECTORY: Record<string, TMASContact> = {
  CIRM_ITALY: {
    name: 'CIRM - Centro Internazionale Radio Medico',
    phone: '+39 06 5923331',
    email: 'cirm@cirm.it',
    website: 'https://www.cirmtmas.it',
    hours: '24/7',
    languages: ['Italian', 'English', 'French', 'Spanish'],
    notes: 'Worldwide coverage. Founded 1935. Free service for all nationalities.',
  },
  CCMM_FRANCE: {
    name: 'CCMM - Centre de Consultations Médicales Maritimes',
    phone: '+33 5 61 49 33 33',
    email: 'ccmm@chu-toulouse.fr',
    website: 'https://www.chu-toulouse.fr/ccmm',
    hours: '24/7',
    languages: ['French', 'English'],
    notes: 'Toulouse University Hospital. Official French TMAS.',
  },
  MEDICO_GERMANY: {
    name: 'Medico Cuxhaven (Telemedical Maritime Assistance Service)',
    phone: '+49 4721 785 0',
    email: 'tmas@bg-verkehr.de',
    website: 'https://www.deutsche-flagge.de/en/maritime-medicine/tmas',
    hours: '24/7',
    languages: ['German', 'English'],
    notes: 'Hamburg Port Health Center. Only flag state mandating AEDs.',
  },
  RMN_NORWAY: {
    name: 'Radio Medico Norway',
    phone: '+47 55 58 20 00',
    website: 'https://helse-bergen.no/radio-medico',
    hours: '24/7',
    languages: ['Norwegian', 'English'],
    notes: 'Based at Haukeland University Hospital, Bergen.',
  },
  MRCC_DENMARK: {
    name: 'MRCC Denmark / Radio Medical Denmark',
    phone: '+45 72 85 03 70',
    hours: '24/7',
    languages: ['Danish', 'English'],
    notes: 'Via Danish Maritime Authority.',
  },
  MRCC_NETHERLANDS: {
    name: 'MRCC Netherlands / Radio Medical',
    phone: '+31 223 542 300',
    hours: '24/7',
    languages: ['Dutch', 'English'],
    notes: 'Rotterdam Protocol compliance.',
  },
  MEDICO_GREECE: {
    name: 'Hellenic Red Cross MEDICO',
    phone: '+30 210 523 0880',
    hours: '24/7',
    languages: ['Greek', 'English'],
    notes: 'Via Hellenic Coast Guard.',
  },
  CCMM_SPAIN: {
    name: 'CCMM Valencia / Radio Médica España',
    phone: '+34 900 202 112',
    hours: '24/7',
    languages: ['Spanish', 'English'],
    notes: 'Instituto Social de la Marina.',
  },
  MCA_UK: {
    name: 'MCA Radio Medical (via Aberdeen)',
    phone: '+44 1224 592 334',
    hours: '24/7',
    languages: ['English'],
    notes: 'Via Maritime and Coastguard Agency.',
  },
  USCG_USA: {
    name: 'USCG Medical Consultation',
    phone: '+1 757 398 6700',
    hours: '24/7',
    languages: ['English'],
    notes: 'Via USCG National Response Center.',
  },
  MPA_SINGAPORE: {
    name: 'MPA Singapore Radio Medical',
    phone: '+65 6325 2493',
    hours: '24/7',
    languages: ['English', 'Mandarin'],
    notes: 'Via Maritime and Port Authority.',
  },
};

// Paris MOU Flag State Database
// White List: Quality flags with good performance
// Grey List: Average performance flags  
// Black List: Poor performance flags - high/very high risk

// Official document links for reference
export const OFFICIAL_DOCS = {
  WHO_GUIDE: 'https://apps.who.int/iris/bitstream/handle/10665/43814/9789240682313_eng.pdf',
  UK_MSN_1905: 'https://assets.publishing.service.gov.uk/media/6059f0c68fa8f545d879f0c6/MSN_1905__M+F_.pdf',
  UK_MSN_1768: 'https://www.classnk.or.jp/hp/pdf/activities/statutory/ism/flag/uk/MSN_1768.pdf',
  MARSHALL_MI108: 'https://www.register-iri.com/wp-content/uploads/MI-108.pdf',
  MARSHALL_MN7042: 'https://www.register-iri.com/wp-content/uploads/MN-7-042-1.pdf',
  PANAMA_MMC339: 'https://www.panamashipregistry.com/wp-content/uploads/2021/03/MMC-339-MEDICINE-CHEST-AND-MEDICAL-EQUIPMENT.MARCH_.2021-rev.RB_.pdf',
  LIBERIA_MLC005: 'https://seafarma.eu/wp-content/uploads/2024/02/Liberia-Marine-Notice-MLC-005.pdf',
  MALTA_MEDICAL: 'https://www.transport.gov.mt/include/filestreaming.asp?fileid=8366',
  // Paris MOU 2024 Official Lists (valid 1 July 2025 - 30 June 2026)
  PARIS_MOU_WHITE_2024: 'https://parismou.org/system/files/2025-06/Paris%20MoU%20White%20List%202024.pdf',
  PARIS_MOU_GREY_2024: 'https://parismou.org/system/files/2025-06/Paris%20MoU%20Grey%20List%202024.pdf',
  PARIS_MOU_BLACK_2024: 'https://parismou.org/system/files/2025-06/Paris%20MoU%20Black%20List%202024.pdf',
  PARIS_MOU_FULL_2024: 'https://parismou.org/system/files/2025-06/WGB%20Flag%20performance%20list%202024.pdf',
};

// Paris MOU 2024 List Statistics:
// White List: 40 flag states
// Grey List: 17 flag states
// Black List: 12 flag states (Medium, Medium-High, High, Very High Risk)
// Total: 69 flag states
// Valid: 1 July 2025 - 30 June 2026

export const FLAG_STATES: FlagState[] = [
  // WHITE LIST 2024 - Top performers
  { id: 'fr', country_name: 'France', country_code: 'FR', flag_emoji: '🇫🇷', paris_mou_status: 'white', paris_mou_rank: 1, slug: 'france-flag-medical-requirements', excerpt: 'France ranks #1 on Paris MOU White List 2024 (up from #11). CCMM Toulouse provides TMAS services.', content: `# France Flag Medical Requirements

France tops the Paris MOU White List 2024, jumping from #11 to #1 with the best performance results.

## Maritime Authority
**Direction des Affaires Maritimes**
Website: https://mer.gouv.fr

## TMAS Service
**CCMM Toulouse (Centre de Consultations Médicales Maritimes)**
- Phone: +33 5 61 49 33 33
- Available 24/7

## Legal Framework
- EU Directive 92/29/EEC
- French Maritime Labour Code
- MLC 2006, Regulation 4.1

## Medical Chest Categories
### Category A - Ocean Going (>175nm)
- Complete pharmaceutical inventory
- Controlled substances under Master's custody
- Emergency resuscitation equipment
- AED recommended

### Category B - Short International (≤175nm)
- Modified pharmaceutical list
- Basic emergency equipment

### Category C - Coastal (≤20nm)
- Basic first aid kit

## Key Requirements
- Annual inspection by approved pharmacist
- Medical logbook per MLC 2006
- CCMM contact information displayed
- WHO International Medical Guide onboard

## Private Yachts vs Commercial Vessels
### Commercial Vessels
- Full compliance with EU Directive 92/29/EEC
- Category A/B/C based on trading area

### Private Yachts (RIF - Registre International Français)
- Yachts >24m: Commercial yacht code applies
- Yachts <24m: Reduced requirements
- Charter yachts: Full commercial requirements

## Equipment Beyond WHO Guide
- AED strongly recommended for passenger vessels
- Oxygen resuscitation equipment mandatory Cat A
- Telemedicine equipment recommended`, medical_categories: ['A', 'B', 'C'], key_requirements: ['EU Directive 92/29/EEC', 'Annual inspection', 'CCMM Toulouse contact', 'MLC 2006'], inspection_interval_months: 12, maritime_authority: 'Direction des Affaires Maritimes', authority_website: 'https://mer.gouv.fr', tmas: TMAS_DIRECTORY.CCMM_FRANCE, yacht_requirements: { applicable: true, code_name: 'Division 240/241', min_length_meters: 24, categories: ['Commercial Yacht', 'Private Yacht', 'Charter'], differences_from_commercial: ['Reduced medical inventory for private <24m', 'Charter yachts full commercial requirements'], medical_personnel_required: false, doctor_required_passengers: 100 }, equipment_differences: { aed_required: false, aed_recommendation: 'Strongly recommended for passenger vessels', oxygen_equipment_required: true, stretcher_required: true, additional_equipment: ['Telemedicine equipment recommended', 'WHO Antidote Kit for chemical tankers'], who_guide_deviations: ['Additional French-specific medications', 'Stricter controlled substances regulations'] }, published: true, created_at: new Date().toISOString(), updated_at: new Date().toISOString() },
  { id: 'dk', country_name: 'Denmark', country_code: 'DK', flag_emoji: '🇩🇰', paris_mou_status: 'white', paris_mou_rank: 2, slug: 'denmark-flag-medical-requirements', excerpt: 'Denmark ranks #2 on Paris MOU White List 2024 (was #1). Danish Maritime Authority sets comprehensive medical requirements per EU Directive 92/29/EEC.', content: `# Denmark Flag Medical Requirements

Denmark ranks #2 on the Paris MOU White List 2024 (previously held #1 for two consecutive years).

## Maritime Authority
**Danish Maritime Authority (Søfartsstyrelsen)**
Website: https://dma.dk

## Legal Framework
- EU Directive 92/29/EEC (Medical Treatment on Board)
- Danish Executive Order on Medical Stores
- MLC 2006, Regulation 4.1

## Medical Chest Categories

### Category A - Ocean Going (>175nm from port)
- Complete pharmaceutical inventory
- Controlled substances under Master's custody
- Oxygen resuscitation equipment
- AED (Automated External Defibrillator) recommended
- Telemedicine equipment recommended

### Category B - Short International (≤175nm)
- Modified pharmaceutical inventory
- Basic emergency supplies
- First aid equipment

### Category C - Coastal/Domestic
- Basic first aid kit
- Emergency contact information

## Key Requirements
- Annual inspection by approved medical supplier
- Medical logbook maintained per MLC 2006
- At least one officer with valid Medical Care (MC) certificate
- Controlled substances register (bound book)
- WHO International Medical Guide for Ships onboard

## Training Requirements
- Medical First Aid (MFA): All deck officers
- Medical Care (MC): Designated medical officer
- Refresher training: Every 5 years

## TMAS Contact
Danish TMAS available 24/7 through Radio Medical services.`, medical_categories: ['A', 'B', 'C'], key_requirements: ['Annual inspection', 'MLC 2006', 'EU Directive 92/29/EEC', 'MC certificate', 'WHO Medical Guide'], inspection_interval_months: 12, maritime_authority: 'Danish Maritime Authority (Søfartsstyrelsen)', authority_website: 'https://dma.dk', published: true, created_at: new Date().toISOString(), updated_at: new Date().toISOString() },
  { id: 'no', country_name: 'Norway', country_code: 'NO', flag_emoji: '🇳🇴', paris_mou_status: 'white', paris_mou_rank: 3, slug: 'norway-flag-medical-requirements', excerpt: 'Norway ranks #3 on Paris MOU White List 2024. Norwegian Maritime Authority sets strict Nordic medical standards.', content: '# Norway Flag Medical Requirements\n\nNorway ranks #3 on Paris MOU White List 2024.\n\n## Maritime Authority\n**Norwegian Maritime Authority (Sjøfartsdirektoratet)**\nWebsite: https://sdir.no\n\n## Categories\n- **Category A**: Unlimited, full inventory\n- **Category B**: Within 200nm, reduced\n- **Category C**: Coastal/Fjord\n\n## Requirements\n- 12-month inspection\n- TMAS contact displayed\n- Nordic Medical Standards\n- MLC 2006 compliance', medical_categories: ['A', 'B', 'C'], key_requirements: ['Annual inspection', 'TMAS contact', 'Nordic standards', 'MLC 2006'], inspection_interval_months: 12, maritime_authority: 'Norwegian Maritime Authority', authority_website: 'https://sdir.no', published: true, created_at: new Date().toISOString(), updated_at: new Date().toISOString() },
  { id: 'mh', country_name: 'Marshall Islands', country_code: 'MH', flag_emoji: '🇲🇭', paris_mou_status: 'white', paris_mou_rank: 3, slug: 'marshall-islands-flag-medical-requirements', excerpt: 'Marshall Islands ranks #3. One of the largest ship registries with comprehensive MI-108 regulations and WHO inventory standards.', content: `# Marshall Islands Medical Requirements

The Republic of the Marshall Islands (RMI) maintains one of the world's largest ship registries, consistently ranking in the top 3 on Paris MOU White List.

## Maritime Authority
**Republic of the Marshall Islands Maritime Administrator**
Administered by: International Registries, Inc. (IRI)
Website: https://register-iri.com

## Official Documents
- **MI-108**: RMI Maritime Regulations (Medical Care Section)
- **MN 7-042-1**: Medical Care Aboard Ship and Ashore
- Download: https://www.register-iri.com/wp-content/uploads/MI-108.pdf

## Medical Inventory Categories

### Ocean Going Vessels (Unlimited)
- WHO recommended pharmaceutical list
- Comprehensive narcotics inventory under Master's custody
- Emergency resuscitation equipment including AED
- Telemedicine equipment strongly recommended
- Ship's Medicine Chest per ICS publication

### Short International Voyages
- Modified medical chest
- Basic emergency supplies
- First aid kits

## Key Requirements per MI-108
- Medical chest inspection every 12 months
- Controlled substances register maintained by Master
- Designated officer with Medical Care training
- WHO Antidote Kit for tankers with dangerous goods
- Medical report forms per MLC Guideline B4.1.2

## Training Requirements (STCW)
- Medical First Aid: All deck officers
- Medical Care: Designated medical officer
- Refresher: Every 5 years

## Special Requirements
- Chemical tankers: MFAG compliance required
- Passenger vessels: Doctor based on capacity
- All vessels: Ship Sanitation Certificate

## TMAS Services
RMI recommends telemedicine connectivity for all ocean-going vessels.`, medical_categories: ['A', 'B', 'C'], key_requirements: ['MI-108 compliance', 'WHO inventory', '12-month inspection', 'MN 7-042-1', 'STCW MC certificate'], inspection_interval_months: 12, maritime_authority: 'Marshall Islands Maritime Administrator (IRI)', authority_website: 'https://register-iri.com', published: true, created_at: new Date().toISOString(), updated_at: new Date().toISOString() },
  { id: 'bm', country_name: 'Bermuda', country_code: 'BM', flag_emoji: '🇧🇲', paris_mou_status: 'white', paris_mou_rank: 4, slug: 'bermuda-flag-medical-requirements', excerpt: 'Bermuda (UK) ranks #4. British Red Ensign registry with UK standards.', content: '# Bermuda Flag Medical Requirements\n\nBritish Overseas Territory, ranks #4.\n\n## Requirements\n- UK MSN 1768 adopted\n- Annual BSMA inspection\n- MLC 2006 compliance', medical_categories: ['A', 'B', 'C'], key_requirements: ['UK standards', 'BSMA certificate', 'MLC 2006'], inspection_interval_months: 12, maritime_authority: 'Bermuda Shipping and Maritime Authority', authority_website: 'https://bermudashipping.bm', published: true, created_at: new Date().toISOString(), updated_at: new Date().toISOString() },
  { id: 'nl', country_name: 'Netherlands', country_code: 'NL', flag_emoji: '🇳🇱', paris_mou_status: 'white', paris_mou_rank: 4, slug: 'netherlands-flag-medical-requirements', excerpt: 'Netherlands ranks #4 on Paris MOU White List 2024 (was #2). Strong maritime tradition with EU compliance.', content: '# Netherlands Flag Medical Requirements\n\nRanks #4 on Paris MOU White List 2024 (dropped from #2).\n\n## Maritime Authority\n**Human Environment and Transport Inspectorate (ILT)**\nWebsite: https://ilent.nl\n\n## Requirements\n- ILT inspection\n- Rotterdam Protocol for TMAS\n- EU Directive 92/29/EEC\n- MLC 2006 compliance', medical_categories: ['A', 'B', 'C'], key_requirements: ['ILT inspection', 'Rotterdam Protocol', 'EU Directive', 'MLC 2006'], inspection_interval_months: 12, maritime_authority: 'Netherlands ILT', authority_website: 'https://ilent.nl', published: true, created_at: new Date().toISOString(), updated_at: new Date().toISOString() },
  { id: 'sg', country_name: 'Singapore', country_code: 'SG', flag_emoji: '🇸🇬', paris_mou_status: 'white', paris_mou_rank: 5, slug: 'singapore-flag-medical-requirements', excerpt: 'Singapore ranks #5 on Paris MOU White List 2024 (was #4). Major Asian hub with MPA standards.', content: '# Singapore Flag Medical Requirements\n\nRanks #5 on Paris MOU White List 2024.\n\n## Maritime Authority\n**Maritime and Port Authority of Singapore (MPA)**\nWebsite: https://mpa.gov.sg\n\n## Requirements\n- MPA approved supplier\n- 12-month inspection\n- MLC 2006 compliance\n- Merchant Shipping (Medical Stores) Regulations', medical_categories: ['A', 'B', 'C'], key_requirements: ['MPA inspection', 'Singapore certification', 'MLC 2006'], inspection_interval_months: 12, maritime_authority: 'Maritime and Port Authority of Singapore', authority_website: 'https://mpa.gov.sg', published: true, created_at: new Date().toISOString(), updated_at: new Date().toISOString() },
  { id: 'ky', country_name: 'Cayman Islands', country_code: 'KY', flag_emoji: '🇰🇾', paris_mou_status: 'white', paris_mou_rank: 6, slug: 'cayman-islands-flag-medical-requirements', excerpt: 'Cayman Islands ranks #6 on Paris MOU White List 2024 (up from #17). British Red Ensign with UK standards.', content: '# Cayman Islands Flag Medical Requirements\n\nRanks #6 on Paris MOU White List 2024 (jumped from #17).\n\n## Maritime Authority\n**Cayman Islands Shipping Registry (CISR)**\nWebsite: https://cishipping.com\n\n## Requirements\n- CISR certificate\n- UK standards adopted\n- MLC 2006 compliance', medical_categories: ['A', 'B', 'C'], key_requirements: ['CISR certificate', 'UK standards', 'MLC 2006'], inspection_interval_months: 12, maritime_authority: 'Cayman Islands Shipping Registry', authority_website: 'https://cishipping.com', published: true, created_at: new Date().toISOString(), updated_at: new Date().toISOString() },
  { id: 'fi', country_name: 'Finland', country_code: 'FI', flag_emoji: '🇫🇮', paris_mou_status: 'white', paris_mou_rank: 7, slug: 'finland-flag-medical-requirements', excerpt: 'Finland ranks #7 on Paris MOU White List 2024 (was #6). Nordic medical standards with EU compliance.', content: '# Finland Flag Medical Requirements\n\nRanks #7 on Paris MOU White List 2024.\n\n## Maritime Authority\n**Finnish Transport and Communications Agency (Traficom)**\nWebsite: https://traficom.fi\n\n## Requirements\n- EU Directive 92/29/EEC\n- Nordic Medical Standards\n- Annual inspection\n- MLC 2006 compliance', medical_categories: ['A', 'B', 'C'], key_requirements: ['EU Directive', 'Nordic Standards', 'Annual inspection', 'MLC 2006'], inspection_interval_months: 12, maritime_authority: 'Traficom Finland', authority_website: 'https://traficom.fi', published: true, created_at: new Date().toISOString(), updated_at: new Date().toISOString() },
  { id: 'it', country_name: 'Italy', country_code: 'IT', flag_emoji: '🇮🇹', paris_mou_status: 'white', paris_mou_rank: 8, slug: 'italy-flag-medical-requirements', excerpt: 'Italy ranks #8 on Paris MOU White List 2024 (was #5). Home of CIRM - the world\'s oldest TMAS service (founded 1935).', content: `# Italy Flag Medical Requirements

Ranks #8 on Paris MOU White List 2024. Home to CIRM, the world's oldest and most renowned TMAS.

## Maritime Authority
**Italian Coast Guard (Guardia Costiera)**
Website: https://guardiacostiera.gov.it

## TMAS Service - CIRM (World's Oldest)
**Centro Internazionale Radio Medico (CIRM)**
- Phone: +39 06 5923331 (24/7)
- Email: cirm@cirm.it
- Website: https://www.cirmtmas.it
- Founded: 1935
- Coverage: Worldwide (all nationalities, FREE service)
- Languages: Italian, English, French, Spanish

CIRM has assisted over 81,000 patients since inception with 500,000+ medical messages.

## Legal Framework
- EU Directive 92/29/EEC
- Italian Navigation Code
- MLC 2006

## Commercial Vessels vs Private Yachts

### Commercial Vessels
- Full EU Directive compliance
- Category A/B/C based on navigation area
- CIRM contact mandatory onboard

### Private Yachts
- Yachts >24m: Commercial code applies
- Charter yachts: Full commercial requirements
- Private <24m: Reduced national requirements

## Equipment Requirements
- AED: Strongly recommended
- Oxygen equipment: Required Cat A
- Stretcher: Required
- CIRM contact details displayed`, medical_categories: ['A', 'B', 'C'], key_requirements: ['CIRM TMAS contact', 'EU Directive 92/29/EEC', 'Annual inspection', 'MLC 2006'], inspection_interval_months: 12, maritime_authority: 'Italian Coast Guard', authority_website: 'https://guardiacostiera.gov.it', tmas: TMAS_DIRECTORY.CIRM_ITALY, yacht_requirements: { applicable: true, code_name: 'Italian Yacht Code', min_length_meters: 24, categories: ['Commercial Yacht', 'Charter', 'Private'], differences_from_commercial: ['Private <24m reduced requirements', 'Charter yachts full compliance'], medical_personnel_required: false, doctor_required_passengers: 100 }, equipment_differences: { aed_required: false, aed_recommendation: 'Strongly recommended for all vessels', oxygen_equipment_required: true, stretcher_required: true, additional_equipment: ['CIRM contact details displayed'], who_guide_deviations: ['Italian-specific pharmaceutical list'] }, published: true, created_at: new Date().toISOString(), updated_at: new Date().toISOString() },
  { id: 'lu', country_name: 'Luxembourg', country_code: 'LU', flag_emoji: '🇱🇺', paris_mou_status: 'white', paris_mou_rank: 9, slug: 'luxembourg-flag-medical-requirements', excerpt: 'Luxembourg ranks #9 on Paris MOU White List 2024 (up from #19). Landlocked country with strong maritime registry.', content: '# Luxembourg Flag Medical Requirements\n\nRanks #9 on Paris MOU White List 2024 (jumped from #19).\n\n## Maritime Authority\n**Commissariat aux Affaires Maritimes**\nWebsite: https://cam.gouvernement.lu\n\n## Requirements\n- EU Directive 92/29/EEC\n- Annual inspection\n- MLC 2006 compliance', medical_categories: ['A', 'B', 'C'], key_requirements: ['EU Directive', 'Annual inspection', 'MLC 2006'], inspection_interval_months: 12, maritime_authority: 'Commissariat aux Affaires Maritimes', authority_website: 'https://cam.gouvernement.lu', published: true, created_at: new Date().toISOString(), updated_at: new Date().toISOString() },
  { id: 'jp', country_name: 'Japan', country_code: 'JP', flag_emoji: '🇯🇵', paris_mou_status: 'white', paris_mou_rank: 10, slug: 'japan-flag-medical-requirements', excerpt: 'Japan ranks #10 on Paris MOU White List 2024 (was #7). Major shipbuilding nation with JCG oversight.', content: '# Japan Flag Medical Requirements\n\nRanks #10 on Paris MOU White List 2024.\n\n## Maritime Authority\n**Japan Coast Guard / MLIT**\nWebsite: https://mlit.go.jp\n\n## Requirements\n- JCG inspection certificates\n- Japanese approved supplier\n- MLC 2006 compliance', medical_categories: ['A', 'B', 'C'], key_requirements: ['JCG certificate', 'Japanese supplier', 'MLC 2006'], inspection_interval_months: 12, maritime_authority: 'Japan Coast Guard / MLIT', authority_website: 'https://mlit.go.jp', published: true, created_at: new Date().toISOString(), updated_at: new Date().toISOString() },
  { id: 'bs', country_name: 'Bahamas', country_code: 'BS', flag_emoji: '🇧🇸', paris_mou_status: 'white', paris_mou_rank: 16, slug: 'bahamas-flag-medical-requirements', excerpt: 'Bahamas ranks #16 on Paris MOU White List 2024 (was #10). Major open registry with WHO standards.', content: '# Bahamas Flag Medical Requirements\n\nRanks #16 on Paris MOU White List 2024 (dropped from top 10).\n\n## Maritime Authority\n**Bahamas Maritime Authority (BMA)**\nWebsite: https://bahamasmaritime.com\n\n## Requirements\n- BMA inspection every 12 months\n- WHO pharmaceutical list\n- MLC 2006 compliance', medical_categories: ['A', 'B', 'C'], key_requirements: ['BMA inspection', 'WHO inventory', 'MLC 2006'], inspection_interval_months: 12, maritime_authority: 'Bahamas Maritime Authority', authority_website: 'https://bahamasmaritime.com', published: true, created_at: new Date().toISOString(), updated_at: new Date().toISOString() },
  { id: 'gr', country_name: 'Greece', country_code: 'GR', flag_emoji: '🇬🇷', paris_mou_status: 'white', paris_mou_rank: 11, slug: 'greece-flag-medical-requirements', excerpt: 'Greece ranks #11 on Paris MOU White List 2024. Major maritime nation with PD 376/1995 regulations and Hellenic MEDICO.', content: '# Greece Flag Medical Requirements\n\nRanks #11 on Paris MOU White List 2024, major ship-owning nation.\n\n## Maritime Authority\n**Ministry of Maritime Affairs and Insular Policy**\nWebsite: https://hcg.gr\n\n## TMAS Service\n**Hellenic Red Cross MEDICO**\n- Phone: +30 210 523 0880\n- Available 24/7\n\n## Requirements\n- PD 376/1995 compliance\n- EU Directive 92/29/EEC\n- Annual port health inspection\n- MEDICO contact displayed', medical_categories: ['A', 'B', 'C'], key_requirements: ['PD 376/1995', 'EU Directive', 'Port health inspection', 'MEDICO'], inspection_interval_months: 12, maritime_authority: 'Ministry of Maritime Affairs', authority_website: 'https://hcg.gr', published: true, created_at: new Date().toISOString(), updated_at: new Date().toISOString() },
  { id: 'gb', country_name: 'United Kingdom', country_code: 'GB', flag_emoji: '🇬🇧', paris_mou_status: 'white', paris_mou_rank: 18, slug: 'uk-flag-medical-requirements', excerpt: 'UK ranks #18 on Paris MOU White List 2024 (dropped from #8). Comprehensive MSN 1905 standards with MCA approved suppliers.', content: `# UK Flag Medical Requirements

UK ranks #18 on the Paris MOU White List 2024 (dropped from #8). The MCA sets medical stores requirements through MSN 1905.

## Maritime Authority
**Maritime and Coastguard Agency (MCA)**
Website: https://www.gov.uk/mca

## Official Documents
- **MSN 1905 (M+F)**: Current medical stores regulations
- **MSN 1768 (M+F)**: Previous version (withdrawn)
- Download: https://assets.publishing.service.gov.uk/media/6059f0c68fa8f545d879f0c6/MSN_1905__M+F_.pdf

## Categories Based on Trading Area

### Category A (Unlimited Area) - >175nm from shore
- Full pharmaceutical inventory per Annex 1
- Doctor's letter for controlled drugs
- Oxygen resuscitation equipment
- AED strongly recommended
- Telemedicine capability recommended

### Category B (Medium Range) - ≤175nm from shore
- Modified pharmaceutical list per Annex 2
- Basic emergency equipment

### Category C (Coastal) - ≤20nm from shore
- Basic first aid kit per Annex 3
- Minimum emergency supplies

## Key Requirements
- Annual inspection by MCA approved pharmacist
- Controlled drugs recorded in bound register
- Ship Captain's Medical Guide onboard
- WHO International Medical Guide recommended

## MCA Approved Medical Suppliers
- Must use MCA approved supplier for inspections
- Certificates accepted at Port State Control worldwide
- List available on MCA website

## Training Requirements
- STCW Medical First Aid: All deck officers
- STCW Medical Care: Designated officer
- MCA approved training providers
- Refresher: Every 5 years

## Private Yachts vs Commercial Vessels

### Commercial Vessels (Merchant Ships)
- Full MSN 1905 compliance
- Category A/B/C based on trading area

### Large Commercial Yachts (LY3 Code)
The Large Commercial Yacht Code (LY3) applies to:
- Yachts ≥24m load line length
- No more than 12 passengers
- Commercial operation (charter)

**LY3 Medical Requirements:**
- Similar to Category B for most operations
- Reduced requirements possible based on risk assessment
- AED strongly recommended
- Ship Captain's Medical Guide required

### Private Yachts (Non-Commercial)
- Coded yachts: Follow LY3 or SCV Code
- Uncoded private: No statutory requirements (recommendation to follow WHO Guide)

## Equipment Beyond WHO Guide
- AED: Recommended based on risk assessment (MGN 297)
- Oxygen resuscitation equipment: Required Cat A
- Stretcher: Required
- Telemedicine: Strongly recommended`, medical_categories: ['A', 'B', 'C'], key_requirements: ['MSN 1905', 'MCA approved inspection', 'Controlled drugs register', 'Ship Captain Medical Guide', 'LY3 for yachts'], inspection_interval_months: 12, maritime_authority: 'Maritime and Coastguard Agency (MCA)', authority_website: 'https://gov.uk/mca', tmas: TMAS_DIRECTORY.MCA_UK, yacht_requirements: { applicable: true, code_name: 'LY3 (Large Yacht Code 3)', min_length_meters: 24, categories: ['Large Commercial Yacht', 'SCV Code', 'Private Uncoded'], differences_from_commercial: ['Reduced Category B equivalent for most yacht operations', 'Risk assessment based AED carriage', 'Ship Captain Medical Guide mandatory'], medical_personnel_required: false, doctor_required_passengers: 100 }, equipment_differences: { aed_required: false, aed_recommendation: 'Recommended per MGN 297 based on risk assessment. Required if >1 use expected per 5 years.', oxygen_equipment_required: true, stretcher_required: true, additional_equipment: ['Spine board recommended', 'Telemedicine equipment recommended'], who_guide_deviations: ['UK-specific medication list in MSN 1905 Annexes', 'Different controlled substances regulations'] }, published: true, created_at: new Date().toISOString(), updated_at: new Date().toISOString() },
  { id: 'lr', country_name: 'Liberia', country_code: 'LR', flag_emoji: '🇱🇷', paris_mou_status: 'white', paris_mou_rank: 12, slug: 'liberia-flag-medical-requirements', excerpt: 'Liberia ranks #12. World\'s second largest registry administered by LISCR with comprehensive Marine Notice requirements.', content: `# Liberia Flag Medical Requirements

The Liberian International Ship & Corporate Registry (LISCR) administers the world's second-largest ship registry.

## Maritime Authority
**Liberian International Ship & Corporate Registry (LISCR)**
Website: https://liscr.com

## Official Documents
- **Marine Notice MLC-005**: Medical Care Standards
- **Marine Notice Index**: https://media.liscr.com/marketing/liscr/media/liscr/online%20library/maritime/marine%20notices%20index.pdf
- Download: https://seafarma.eu/wp-content/uploads/2024/02/Liberia-Marine-Notice-MLC-005.pdf

## Medical Chest Categories

### A1/A2 - Full Ocean Going
- WHO International Medical Guide for Ships
- Complete pharmaceutical inventory
- Comprehensive narcotics under Master's custody
- Emergency resuscitation equipment

### A3 - Vessels <3,000 GT
- Modified inventory
- Basic emergency supplies

### A4 - Coastal Trading
- Basic supplies
- First aid equipment

## Key Requirements
- Annual inspection by competent authority
- Accepts inspection certificates from approved port pharmacies worldwide
- Medical logbook maintained
- Controlled substances register

## Special Requirements
- Tankers with hazardous cargo: WHO Antidote Kit
- Passenger vessels: Medical personnel based on capacity
- Chemical carriers: MFAG compliance

## Training Requirements
- Medical Care (MC): Designated officer
- Basic First Aid: All crew
- STCW certification required
- Record keeping per MLC 2006`, medical_categories: ['A1/A2', 'A3', 'A4'], key_requirements: ['Marine Notice MLC-005', 'WHO inventory', 'Annual inspection', 'Worldwide pharmacy acceptance'], inspection_interval_months: 12, maritime_authority: 'LISCR - Liberian Registry', authority_website: 'https://liscr.com', published: true, created_at: new Date().toISOString(), updated_at: new Date().toISOString() },
  { id: 'mt', country_name: 'Malta', country_code: 'MT', flag_emoji: '🇲🇹', paris_mou_status: 'white', paris_mou_rank: 14, slug: 'malta-flag-medical-requirements', excerpt: 'Malta ranks #14. Largest EU ship registry with comprehensive medical requirements per Technical Notice SLS.32.', content: `# Malta Flag Medical Requirements

Transport Malta maintains the EU's largest ship registry with comprehensive medical equipment requirements.

## Maritime Authority
**Transport Malta - Merchant Shipping Directorate**
Website: https://transport.gov.mt

## Official Documents
- **Technical Notice SLS.32**: Labelling of Medical Stores
- **MS Notice 121**: Survey Requirements
- Medical Stores Guide: https://www.transport.gov.mt/include/filestreaming.asp?fileid=8366

## Medical Chest Categories

### Category A - Ocean Going (>175nm)
- Full pharmaceutical inventory
- Narcotics under Master's custody
- Emergency trauma supplies
- Defibrillator (AED) recommended
- TMAS contact information displayed

### Category B - Coastal (≤175nm)
- Reduced pharmaceutical inventory
- Basic emergency supplies
- First aid equipment

### Category C - Day Boats (≤20nm)
- Basic first aid kit
- Emergency contact information

## Key Requirements per EU Directive 92/29/EEC
- Annual inspection by approved medical supplier
- Transport Malta inspection certificates
- Medical logbook per MLC 2006
- At least one officer with valid MC certificate
- Merchant Shipping Notice compliance

## Training Requirements
- STCW Medical First Aid: All officers
- STCW Medical Care: Designated officer
- Malta approved training centers
- Refresher: Every 5 years

## Publications Required Onboard
- WHO International Medical Guide for Ships
- Ship Captain's Medical Guide`, medical_categories: ['A', 'B', 'C'], key_requirements: ['Technical Notice SLS.32', 'Transport Malta certificate', 'EU Directive 92/29/EEC', 'MLC 2006'], inspection_interval_months: 12, maritime_authority: 'Transport Malta', authority_website: 'https://transport.gov.mt', published: true, created_at: new Date().toISOString(), updated_at: new Date().toISOString() },
  { id: 'cy', country_name: 'Cyprus', country_code: 'CY', flag_emoji: '🇨🇾', paris_mou_status: 'white', paris_mou_rank: 16, slug: 'cyprus-flag-medical-requirements', excerpt: 'Cyprus ranks #16. Major EU registry with DM Circular 11/2018.', content: '# Cyprus Flag Medical Requirements\n\n## Requirements\n- DM Circular 11/2018\n- EU Directive 92/29/EEC\n- Annual inspection\n- MLC 2006 compliance', medical_categories: ['A', 'B', 'C'], key_requirements: ['DM Circular 11/2018', 'EU Directive', 'Annual inspection'], inspection_interval_months: 12, maritime_authority: 'Cyprus Shipping Deputy Ministry', authority_website: 'https://shipping.gov.cy', published: true, created_at: new Date().toISOString(), updated_at: new Date().toISOString() },
  { id: 'hk', country_name: 'Hong Kong', country_code: 'HK', flag_emoji: '🇭🇰', paris_mou_status: 'white', paris_mou_rank: 17, slug: 'hong-kong-flag-medical-requirements', excerpt: 'Hong Kong ranks #17. Major Asian registry with Marine Department oversight.', content: '# Hong Kong Flag Medical Requirements\n\n## Requirements\n- Marine Department approval\n- Annual inspection\n- MLC 2006 compliance', medical_categories: ['A', 'B', 'C'], key_requirements: ['Marine Dept approval', 'Annual inspection', 'MLC 2006'], inspection_interval_months: 12, maritime_authority: 'Hong Kong Marine Department', authority_website: 'https://mardep.gov.hk', published: true, created_at: new Date().toISOString(), updated_at: new Date().toISOString() },
  { id: 'de', country_name: 'Germany', country_code: 'DE', flag_emoji: '🇩🇪', paris_mou_status: 'white', paris_mou_rank: 12, slug: 'germany-flag-medical-requirements', excerpt: 'Germany on White List. ONLY FLAG STATE TO MANDATE AEDs. Medico Cuxhaven provides TMAS.', content: `# Germany Flag Medical Requirements

Germany is notable for being the ONLY FLAG STATE to mandate Automated External Defibrillators (AEDs) on merchant ships.

## Maritime Authority
**BG Verkehr (German Social Accident Insurance)**
Website: https://bg-verkehr.de

## TMAS Service - Medico Cuxhaven
**Telemedical Maritime Assistance Service (TMAS)**
- Phone: +49 4721 785 0
- Email: tmas@bg-verkehr.de
- Website: https://www.deutsche-flagge.de/en/maritime-medicine/tmas
- Hours: 24/7
- Languages: German, English

Based at Hamburg Port Health Center.

## Legal Framework
- EU Directive 92/29/EEC
- German Maritime Medical Regulations
- MLC 2006

## ⚡ UNIQUE: Mandatory AED Requirement
Germany is the ONLY flag state in the world to mandate the carriage of Automated External Defibrillators (AEDs) on merchant ships:

**AED Requirements:**
- Mandatory on all German-flagged vessels >500 GT
- Must be maintained and tested
- Crew training required
- Placed in accessible location

## Commercial Vessels vs Private Yachts

### Commercial Vessels
- Full EU Directive compliance
- Mandatory AED carriage
- Category A/B/C based on trading area

### Private Yachts
- Yachts >24m: Commercial requirements apply
- Charter yachts: Full commercial including AED
- Private: AED strongly recommended

## Equipment Beyond WHO Guide (Germany Specific)
- AED: MANDATORY (unique among flag states)
- Oxygen resuscitation equipment: Required
- Stretcher: Required
- Additional German-specific medications
- Telemedicine equipment recommended`, medical_categories: ['A', 'B', 'C'], key_requirements: ['BG Verkehr standards', 'MANDATORY AED', 'EU Directive 92/29/EEC', 'Medico Cuxhaven TMAS', 'MLC 2006'], inspection_interval_months: 12, maritime_authority: 'BG Verkehr', authority_website: 'https://bg-verkehr.de', tmas: TMAS_DIRECTORY.MEDICO_GERMANY, yacht_requirements: { applicable: true, code_name: 'German Yacht Regulations', min_length_meters: 24, categories: ['Commercial Yacht', 'Charter', 'Private'], differences_from_commercial: ['AED still mandatory for charter >500 GT', 'Private recommended but not mandatory'], medical_personnel_required: false, doctor_required_passengers: 100 }, equipment_differences: { aed_required: true, aed_recommendation: 'MANDATORY - Only flag state in the world to require AEDs', oxygen_equipment_required: true, stretcher_required: true, additional_equipment: ['German-specific medication list', 'Telemedicine equipment'], who_guide_deviations: ['MANDATORY AED (unique)', 'German-specific pharmaceutical requirements', 'Stricter controlled substances regulations'] }, published: true, created_at: new Date().toISOString(), updated_at: new Date().toISOString() },
  { id: 'fr', country_name: 'France', country_code: 'FR', flag_emoji: '🇫🇷', paris_mou_status: 'white', paris_mou_rank: 19, slug: 'france-flag-medical-requirements', excerpt: 'France on White List. CCMM sets medical requirements.', content: '# France Flag Medical Requirements\n\n## Requirements\n- CCMM Toulouse contact\n- EU Directive 92/29/EEC\n- Annual inspection', medical_categories: ['A', 'B', 'C'], key_requirements: ['CCMM contact', 'EU Directive', 'Annual inspection'], inspection_interval_months: 12, maritime_authority: 'French Maritime Affairs', authority_website: 'https://mer.gouv.fr', published: true, created_at: new Date().toISOString(), updated_at: new Date().toISOString() },
  { id: 'it', country_name: 'Italy', country_code: 'IT', flag_emoji: '🇮🇹', paris_mou_status: 'white', paris_mou_rank: 20, slug: 'italy-flag-medical-requirements', excerpt: 'Italy on White List. CIRM Rome provides TMAS services.', content: '# Italy Flag Medical Requirements\n\n## Requirements\n- CIRM Rome TMAS\n- EU Directive 92/29/EEC\n- Annual inspection', medical_categories: ['A', 'B', 'C'], key_requirements: ['CIRM TMAS', 'EU Directive', 'Annual inspection'], inspection_interval_months: 12, maritime_authority: 'Italian Coast Guard', authority_website: 'https://guardiacostiera.gov.it', published: true, created_at: new Date().toISOString(), updated_at: new Date().toISOString() },
  { id: 'pa', country_name: 'Panama', country_code: 'PA', flag_emoji: '🇵🇦', paris_mou_status: 'white', paris_mou_rank: 38, slug: 'panama-flag-medical-requirements', excerpt: 'Panama ranks #38. World\'s largest registry by tonnage with comprehensive MMC-339 medical requirements.', content: `# Panama Flag Medical Requirements

The Panama Maritime Authority (AMP) administers the world's largest ship registry by tonnage.

## Maritime Authority
**Autoridad Marítima de Panamá (AMP)**
Website: https://amp.gob.pa

## Official Documents
- **MMC-339**: Medicine Chest and Medical Equipment
- Download: https://www.panamashipregistry.com/wp-content/uploads/2021/03/MMC-339-MEDICINE-CHEST-AND-MEDICAL-EQUIPMENT.MARCH_.2021-rev.RB_.pdf

## Medical Inventory Categories per MMC-339

### Category A (Ocean Navigation)
- Complete pharmaceutical inventory per WHO Guide
- Narcotics and psychotropic substances
- Emergency resuscitation equipment
- Antidotes for hazardous cargo (if applicable)
- AED recommended

### Category B (Coastal Navigation)
- Reduced pharmaceutical inventory
- Basic emergency supplies
- Standard first aid equipment

### Category C (Port Service)
- First aid kit
- Basic emergency supplies

## Required Publications Onboard
- WHO International Medical Guide for Ships (current edition)
- Medical First Aid Guide (MFAG) for dangerous goods carriers
- Ship Captain's Medical Guide

## Key Requirements
- Medical logbook maintained
- Controlled substances register
- Inspection certificates valid for 12 months
- AMP circular compliance

## Training Requirements
- Person in charge of medical care: 40-hour MC course
- Refresher training: Every 5 years
- All crew: Basic first aid
- STCW compliance required

## Inspection Acceptance
Panama accepts inspection certificates from:
- Classification societies
- Approved pharmacies worldwide
- Port State Control recognized suppliers`, medical_categories: ['A', 'B', 'C'], key_requirements: ['MMC-339', 'WHO Medical Guide', '12-month inspection', 'Class society acceptance'], inspection_interval_months: 12, maritime_authority: 'Panama Maritime Authority (AMP)', authority_website: 'https://amp.gob.pa', published: true, created_at: new Date().toISOString(), updated_at: new Date().toISOString() },
  { id: 'us', country_name: 'United States', country_code: 'US', flag_emoji: '🇺🇸', paris_mou_status: 'white', paris_mou_rank: 33, slug: 'usa-flag-medical-requirements', excerpt: 'USA ranks #33. USCG sets requirements via 46 CFR.', content: '# USA Flag Medical Requirements\n\n## Requirements\n- USCG 46 CFR compliance\n- Annual inspection\n- HIPAA compliance for records', medical_categories: ['A', 'B', 'C'], key_requirements: ['46 CFR', 'USCG inspection', 'HIPAA'], inspection_interval_months: 12, maritime_authority: 'US Coast Guard', authority_website: 'https://uscg.mil', published: true, created_at: new Date().toISOString(), updated_at: new Date().toISOString() },
  // Additional White List flags
  { id: 'se', country_name: 'Sweden', country_code: 'SE', flag_emoji: '🇸🇪', paris_mou_status: 'white', paris_mou_rank: 13, slug: 'sweden-flag-medical-requirements', excerpt: 'Sweden ranks #13. Swedish Transport Agency sets medical standards per EU Directive.', content: '# Sweden Flag Medical Requirements\n\nRanks #13 on Paris MOU White List.\n\n## Maritime Authority\n**Swedish Transport Agency (Transportstyrelsen)**\nWebsite: https://transportstyrelsen.se\n\n## Requirements\n- EU Directive 92/29/EEC\n- Annual inspection by approved supplier\n- Nordic Medical Standards\n- TMAS via MRCC Sweden', medical_categories: ['A', 'B', 'C'], key_requirements: ['EU Directive', 'Nordic Standards', 'Annual inspection'], inspection_interval_months: 12, maritime_authority: 'Swedish Transport Agency', authority_website: 'https://transportstyrelsen.se', published: true, created_at: new Date().toISOString(), updated_at: new Date().toISOString() },
  { id: 'be', country_name: 'Belgium', country_code: 'BE', flag_emoji: '🇧🇪', paris_mou_status: 'white', paris_mou_rank: 15, slug: 'belgium-flag-medical-requirements', excerpt: 'Belgium ranks #15. Belgian DG Maritime sets requirements per EU Directive.', content: '# Belgium Flag Medical Requirements\n\nRanks #15 on Paris MOU White List.\n\n## Maritime Authority\n**DG Maritime Transport**\nWebsite: https://mobilit.belgium.be\n\n## Requirements\n- EU Directive 92/29/EEC\n- Annual inspection\n- MLC 2006 compliance', medical_categories: ['A', 'B', 'C'], key_requirements: ['EU Directive', 'Annual inspection', 'MLC 2006'], inspection_interval_months: 12, maritime_authority: 'DG Maritime Transport Belgium', authority_website: 'https://mobilit.belgium.be', published: true, created_at: new Date().toISOString(), updated_at: new Date().toISOString() },
  { id: 'es', country_name: 'Spain', country_code: 'ES', flag_emoji: '🇪🇸', paris_mou_status: 'white', paris_mou_rank: 21, slug: 'spain-flag-medical-requirements', excerpt: 'Spain ranks #21. DGMM sets medical requirements. CCMM Valencia provides TMAS.', content: '# Spain Flag Medical Requirements\n\nRanks #21 on Paris MOU White List.\n\n## Maritime Authority\n**Dirección General de la Marina Mercante (DGMM)**\nWebsite: https://www.mitma.gob.es\n\n## TMAS Service\n**CCMM Valencia**: +34 900 202 112\n\n## Requirements\n- EU Directive 92/29/EEC\n- Annual inspection\n- Spanish medical chest regulations', medical_categories: ['A', 'B', 'C'], key_requirements: ['DGMM regulations', 'EU Directive', 'CCMM Valencia contact'], inspection_interval_months: 12, maritime_authority: 'DGMM Spain', authority_website: 'https://www.mitma.gob.es', published: true, created_at: new Date().toISOString(), updated_at: new Date().toISOString() },
  { id: 'pt', country_name: 'Portugal', country_code: 'PT', flag_emoji: '🇵🇹', paris_mou_status: 'white', paris_mou_rank: 22, slug: 'portugal-flag-medical-requirements', excerpt: 'Portugal ranks #22. DGRM sets requirements. CCMM Lisbon provides TMAS.', content: '# Portugal Flag Medical Requirements\n\nRanks #22 on Paris MOU White List.\n\n## Maritime Authority\n**Direcção-Geral de Recursos Naturais (DGRM)**\nWebsite: https://www.dgrm.mm.gov.pt\n\n## TMAS Service\n**CCMM Lisbon**: +351 21 294 6927\n\n## Requirements\n- EU Directive 92/29/EEC\n- Annual inspection\n- Portuguese maritime regulations', medical_categories: ['A', 'B', 'C'], key_requirements: ['DGRM regulations', 'EU Directive', 'CCMM Lisbon contact'], inspection_interval_months: 12, maritime_authority: 'DGRM Portugal', authority_website: 'https://www.dgrm.mm.gov.pt', published: true, created_at: new Date().toISOString(), updated_at: new Date().toISOString() },
  { id: 'ie', country_name: 'Ireland', country_code: 'IE', flag_emoji: '🇮🇪', paris_mou_status: 'white', paris_mou_rank: 23, slug: 'ireland-flag-medical-requirements', excerpt: 'Ireland ranks #23. Marine Survey Office sets requirements per EU Directive.', content: '# Ireland Flag Medical Requirements\n\nRanks #23 on Paris MOU White List.\n\n## Maritime Authority\n**Marine Survey Office (MSO)**\nWebsite: https://www.gov.ie/maritime\n\n## Requirements\n- EU Directive 92/29/EEC\n- SI 506/1997 Medical Stores Regulations\n- Annual inspection\n- MLC 2006 compliance', medical_categories: ['A', 'B', 'C'], key_requirements: ['SI 506/1997', 'EU Directive', 'Annual inspection'], inspection_interval_months: 12, maritime_authority: 'Marine Survey Office Ireland', authority_website: 'https://www.gov.ie/maritime', published: true, created_at: new Date().toISOString(), updated_at: new Date().toISOString() },
  { id: 'im', country_name: 'Isle of Man', country_code: 'IM', flag_emoji: '🇮🇲', paris_mou_status: 'white', paris_mou_rank: 24, slug: 'isle-of-man-flag-medical-requirements', excerpt: 'Isle of Man ranks #24. British Red Ensign registry with UK-based standards.', content: '# Isle of Man Flag Medical Requirements\n\nRanks #24 on Paris MOU White List. British Crown Dependency.\n\n## Maritime Authority\n**Isle of Man Ship Registry**\nWebsite: https://www.iomshipregistry.com\n\n## Requirements\n- UK MSN 1905 adopted\n- Annual inspection\n- MLC 2006 compliance\n- IOM Ship Registry certificates', medical_categories: ['A', 'B', 'C'], key_requirements: ['UK standards adopted', 'IOM certificates', 'MLC 2006'], inspection_interval_months: 12, maritime_authority: 'Isle of Man Ship Registry', authority_website: 'https://www.iomshipregistry.com', published: true, created_at: new Date().toISOString(), updated_at: new Date().toISOString() },
  { id: 'gi', country_name: 'Gibraltar', country_code: 'GI', flag_emoji: '🇬🇮', paris_mou_status: 'white', paris_mou_rank: 25, slug: 'gibraltar-flag-medical-requirements', excerpt: 'Gibraltar ranks #25. British Red Ensign registry with UK standards.', content: '# Gibraltar Flag Medical Requirements\n\nRanks #25 on Paris MOU White List. British Overseas Territory.\n\n## Maritime Authority\n**Gibraltar Maritime Administration (GMA)**\nWebsite: https://www.gibraltarship.com\n\n## Requirements\n- UK MSN 1905 standards adopted\n- Annual inspection\n- MLC 2006 compliance\n- GMA certificates', medical_categories: ['A', 'B', 'C'], key_requirements: ['UK standards', 'GMA certificates', 'MLC 2006'], inspection_interval_months: 12, maritime_authority: 'Gibraltar Maritime Administration', authority_website: 'https://www.gibraltarship.com', published: true, created_at: new Date().toISOString(), updated_at: new Date().toISOString() },
  { id: 'ag', country_name: 'Antigua and Barbuda', country_code: 'AG', flag_emoji: '🇦🇬', paris_mou_status: 'white', paris_mou_rank: 26, slug: 'antigua-barbuda-flag-medical-requirements', excerpt: 'Antigua and Barbuda ranks #26. ADOMS administers the registry.', content: '# Antigua and Barbuda Flag Medical Requirements\n\nRanks #26 on Paris MOU White List.\n\n## Maritime Authority\n**Antigua and Barbuda Department of Marine Services (ADOMS)**\nWebsite: https://www.abregistry.ag\n\n## Requirements\n- WHO Medical Guide standards\n- Annual inspection\n- MLC 2006 compliance\n- ADOMS circulars', medical_categories: ['A', 'B', 'C'], key_requirements: ['WHO standards', 'ADOMS circulars', 'MLC 2006'], inspection_interval_months: 12, maritime_authority: 'ADOMS', authority_website: 'https://www.abregistry.ag', published: true, created_at: new Date().toISOString(), updated_at: new Date().toISOString() },
  { id: 'fi', country_name: 'Finland', country_code: 'FI', flag_emoji: '🇫🇮', paris_mou_status: 'white', paris_mou_rank: 27, slug: 'finland-flag-medical-requirements', excerpt: 'Finland ranks #27. Finnish Transport and Communications Agency sets requirements.', content: '# Finland Flag Medical Requirements\n\nRanks #27 on Paris MOU White List.\n\n## Maritime Authority\n**Finnish Transport and Communications Agency (Traficom)**\nWebsite: https://www.traficom.fi\n\n## Requirements\n- EU Directive 92/29/EEC\n- Nordic Medical Standards\n- Annual inspection\n- MLC 2006 compliance', medical_categories: ['A', 'B', 'C'], key_requirements: ['EU Directive', 'Nordic Standards', 'Annual inspection'], inspection_interval_months: 12, maritime_authority: 'Traficom Finland', authority_website: 'https://www.traficom.fi', published: true, created_at: new Date().toISOString(), updated_at: new Date().toISOString() },
  { id: 'pl', country_name: 'Poland', country_code: 'PL', flag_emoji: '🇵🇱', paris_mou_status: 'white', paris_mou_rank: 28, slug: 'poland-flag-medical-requirements', excerpt: 'Poland ranks #28. Polish Maritime Administration sets requirements per EU Directive.', content: '# Poland Flag Medical Requirements\n\nRanks #28 on Paris MOU White List.\n\n## Maritime Authority\n**Polish Maritime Administration**\nWebsite: https://www.umgdy.gov.pl\n\n## Requirements\n- EU Directive 92/29/EEC\n- Polish maritime regulations\n- Annual inspection\n- MLC 2006 compliance', medical_categories: ['A', 'B', 'C'], key_requirements: ['EU Directive', 'Polish regulations', 'Annual inspection'], inspection_interval_months: 12, maritime_authority: 'Polish Maritime Administration', authority_website: 'https://www.umgdy.gov.pl', published: true, created_at: new Date().toISOString(), updated_at: new Date().toISOString() },
  { id: 'kr', country_name: 'South Korea', country_code: 'KR', flag_emoji: '🇰🇷', paris_mou_status: 'white', paris_mou_rank: 29, slug: 'south-korea-flag-medical-requirements', excerpt: 'South Korea ranks #29. Korean Maritime Safety Tribunal sets requirements.', content: '# South Korea Flag Medical Requirements\n\nRanks #29 on Paris MOU White List.\n\n## Maritime Authority\n**Korean Maritime Safety Tribunal (KMST)**\nWebsite: https://www.kmst.go.kr\n\n## Requirements\n- Korean Ship Safety Act\n- Annual inspection\n- MLC 2006 compliance', medical_categories: ['A', 'B', 'C'], key_requirements: ['Ship Safety Act', 'KMST inspection', 'MLC 2006'], inspection_interval_months: 12, maritime_authority: 'Korean Maritime Safety Tribunal', authority_website: 'https://www.kmst.go.kr', published: true, created_at: new Date().toISOString(), updated_at: new Date().toISOString() },
  { id: 'au', country_name: 'Australia', country_code: 'AU', flag_emoji: '🇦🇺', paris_mou_status: 'white', paris_mou_rank: 30, slug: 'australia-flag-medical-requirements', excerpt: 'Australia ranks #30. AMSA sets comprehensive medical requirements.', content: '# Australia Flag Medical Requirements\n\nRanks #30 on Paris MOU White List.\n\n## Maritime Authority\n**Australian Maritime Safety Authority (AMSA)**\nWebsite: https://www.amsa.gov.au\n\n## Requirements\n- Marine Order 11 (Living and Working Conditions)\n- Annual inspection\n- MLC 2006 compliance\n- AMSA approved suppliers', medical_categories: ['A', 'B', 'C'], key_requirements: ['Marine Order 11', 'AMSA inspection', 'MLC 2006'], inspection_interval_months: 12, maritime_authority: 'Australian Maritime Safety Authority', authority_website: 'https://www.amsa.gov.au', published: true, created_at: new Date().toISOString(), updated_at: new Date().toISOString() },
  { id: 'nz', country_name: 'New Zealand', country_code: 'NZ', flag_emoji: '🇳🇿', paris_mou_status: 'white', paris_mou_rank: 31, slug: 'new-zealand-flag-medical-requirements', excerpt: 'New Zealand ranks #31. Maritime NZ sets medical standards.', content: '# New Zealand Flag Medical Requirements\n\nRanks #31 on Paris MOU White List.\n\n## Maritime Authority\n**Maritime New Zealand**\nWebsite: https://www.maritimenz.govt.nz\n\n## Requirements\n- Maritime Rules Part 52\n- Annual inspection\n- MLC 2006 compliance', medical_categories: ['A', 'B', 'C'], key_requirements: ['Maritime Rules Part 52', 'Annual inspection', 'MLC 2006'], inspection_interval_months: 12, maritime_authority: 'Maritime New Zealand', authority_website: 'https://www.maritimenz.govt.nz', published: true, created_at: new Date().toISOString(), updated_at: new Date().toISOString() },
  { id: 'ca', country_name: 'Canada', country_code: 'CA', flag_emoji: '🇨🇦', paris_mou_status: 'white', paris_mou_rank: 32, slug: 'canada-flag-medical-requirements', excerpt: 'Canada ranks #32. Transport Canada sets comprehensive medical requirements.', content: '# Canada Flag Medical Requirements\n\nRanks #32 on Paris MOU White List.\n\n## Maritime Authority\n**Transport Canada - Marine Safety**\nWebsite: https://tc.canada.ca/marine\n\n## Requirements\n- Marine Medical Regulations (SOR/2010-134)\n- Annual inspection\n- MLC 2006 compliance\n- Transport Canada approved suppliers', medical_categories: ['A', 'B', 'C'], key_requirements: ['SOR/2010-134', 'TC inspection', 'MLC 2006'], inspection_interval_months: 12, maritime_authority: 'Transport Canada', authority_website: 'https://tc.canada.ca/marine', published: true, created_at: new Date().toISOString(), updated_at: new Date().toISOString() },
  { id: 'vc', country_name: 'St Vincent & Grenadines', country_code: 'VC', flag_emoji: '🇻🇨', paris_mou_status: 'white', paris_mou_rank: 34, slug: 'st-vincent-flag-medical-requirements', excerpt: 'St Vincent & Grenadines ranks #34. Growing open registry.', content: '# St Vincent & Grenadines Flag Medical Requirements\n\nRanks #34 on Paris MOU White List.\n\n## Maritime Authority\n**St Vincent & Grenadines Maritime Administration**\nWebsite: https://www.svg-marad.com\n\n## Requirements\n- WHO Medical Guide standards\n- Annual inspection\n- MLC 2006 compliance', medical_categories: ['A', 'B', 'C'], key_requirements: ['WHO standards', 'Annual inspection', 'MLC 2006'], inspection_interval_months: 12, maritime_authority: 'SVG Maritime Administration', authority_website: 'https://www.svg-marad.com', published: true, created_at: new Date().toISOString(), updated_at: new Date().toISOString() },
  { id: 'vg', country_name: 'British Virgin Islands', country_code: 'VG', flag_emoji: '🇻🇬', paris_mou_status: 'white', paris_mou_rank: 35, slug: 'bvi-flag-medical-requirements', excerpt: 'British Virgin Islands ranks #35. British Red Ensign registry.', content: '# British Virgin Islands Flag Medical Requirements\n\nRanks #35 on Paris MOU White List. British Overseas Territory.\n\n## Maritime Authority\n**BVI Shipping Registry**\nWebsite: https://www.bvimaritime.vg\n\n## Requirements\n- UK standards adopted\n- Annual inspection\n- MLC 2006 compliance', medical_categories: ['A', 'B', 'C'], key_requirements: ['UK standards', 'Annual inspection', 'MLC 2006'], inspection_interval_months: 12, maritime_authority: 'BVI Shipping Registry', authority_website: 'https://www.bvimaritime.vg', published: true, created_at: new Date().toISOString(), updated_at: new Date().toISOString() },
  { id: 'lu', country_name: 'Luxembourg', country_code: 'LU', flag_emoji: '🇱🇺', paris_mou_status: 'white', paris_mou_rank: 36, slug: 'luxembourg-flag-medical-requirements', excerpt: 'Luxembourg ranks #36. Landlocked country with maritime registry.', content: '# Luxembourg Flag Medical Requirements\n\nRanks #36 on Paris MOU White List.\n\n## Maritime Authority\n**Commissariat aux Affaires Maritimes**\nWebsite: https://cam.gouvernement.lu\n\n## Requirements\n- EU Directive 92/29/EEC\n- Annual inspection\n- MLC 2006 compliance', medical_categories: ['A', 'B', 'C'], key_requirements: ['EU Directive', 'Annual inspection', 'MLC 2006'], inspection_interval_months: 12, maritime_authority: 'Commissariat aux Affaires Maritimes', authority_website: 'https://cam.gouvernement.lu', published: true, created_at: new Date().toISOString(), updated_at: new Date().toISOString() },
  { id: 'my', country_name: 'Malaysia', country_code: 'MY', flag_emoji: '🇲🇾', paris_mou_status: 'white', paris_mou_rank: 37, slug: 'malaysia-flag-medical-requirements', excerpt: 'Malaysia ranks #37. Marine Department sets medical standards.', content: '# Malaysia Flag Medical Requirements\n\nRanks #37 on Paris MOU White List.\n\n## Maritime Authority\n**Marine Department Malaysia**\nWebsite: https://www.marine.gov.my\n\n## Requirements\n- Merchant Shipping (Medical Stores) Rules\n- Annual inspection\n- MLC 2006 compliance', medical_categories: ['A', 'B', 'C'], key_requirements: ['Medical Stores Rules', 'Annual inspection', 'MLC 2006'], inspection_interval_months: 12, maritime_authority: 'Marine Department Malaysia', authority_website: 'https://www.marine.gov.my', published: true, created_at: new Date().toISOString(), updated_at: new Date().toISOString() },
  // New on White List 2024 (from Grey)
  { id: 'eg', country_name: 'Egypt', country_code: 'EG', flag_emoji: '🇪🇬', paris_mou_status: 'white', paris_mou_rank: 40, slug: 'egypt-flag-medical-requirements', excerpt: 'Egypt ranks #40 on Paris MOU White List 2024 (up from Grey #50). Improved performance.', content: '# Egypt Flag Medical Requirements\n\nRanks #40 on Paris MOU White List 2024. Moved up from Grey List.\n\n## Maritime Authority\n**Egyptian Maritime Safety Authority**\n\n## Requirements\n- Annual inspection\n- MLC 2006 compliance', medical_categories: ['A', 'B', 'C'], key_requirements: ['Annual inspection', 'MLC 2006'], inspection_interval_months: 12, maritime_authority: 'Egyptian Maritime Safety Authority', published: true, created_at: new Date().toISOString(), updated_at: new Date().toISOString() },
  // GREY LIST 2024 - 17 flag states (average performers)
  { id: 'sa', country_name: 'Saudi Arabia', country_code: 'SA', flag_emoji: '🇸🇦', paris_mou_status: 'grey', paris_mou_rank: 41, slug: 'saudi-arabia-flag-medical-requirements', excerpt: 'Saudi Arabia on Grey List 2024 (#41). Dropped from White List (#38).', content: '# Saudi Arabia Flag Medical Requirements\n\nGrey List 2024 (#41) - Dropped from White List.\n\n## Maritime Authority\n**Saudi Ports Authority (Mawani)**\n\n## Requirements\n- Annual inspection\n- MLC 2006 compliance', medical_categories: ['A', 'B', 'C'], key_requirements: ['Annual inspection', 'MLC 2006'], inspection_interval_months: 12, maritime_authority: 'Saudi Ports Authority', published: true, created_at: new Date().toISOString(), updated_at: new Date().toISOString() },
  { id: 'hr', country_name: 'Croatia', country_code: 'HR', flag_emoji: '🇭🇷', paris_mou_status: 'grey', paris_mou_rank: 42, slug: 'croatia-flag-medical-requirements', excerpt: 'Croatia on Grey List 2024 (#42). Dropped from White List (#37).', content: '# Croatia Flag Medical Requirements\n\nGrey List 2024 (#42) - Dropped from White List.\n\n## Maritime Authority\n**Croatian Maritime Administration**\n\n## Requirements\n- EU Directive 92/29/EEC\n- Annual inspection\n- MLC 2006 compliance', medical_categories: ['A', 'B', 'C'], key_requirements: ['EU Directive', 'Annual inspection', 'MLC 2006'], inspection_interval_months: 12, maritime_authority: 'Croatian Maritime Administration', published: true, created_at: new Date().toISOString(), updated_at: new Date().toISOString() },
  { id: 'cn', country_name: 'China', country_code: 'CN', flag_emoji: '🇨🇳', paris_mou_status: 'grey', paris_mou_rank: 43, slug: 'china-flag-medical-requirements', excerpt: 'China on Grey List 2024 (#43). MSA sets medical standards.', content: '# China Flag Medical Requirements\n\nGrey List 2024 (#43) - Average performance.\n\n## Maritime Authority\n**China Maritime Safety Administration (MSA)**\nWebsite: https://msa.gov.cn\n\n## Requirements\n- MSA China approval\n- Annual inspection\n- Chinese documentation\n- MLC 2006 compliance', medical_categories: ['A', 'B', 'C'], key_requirements: ['MSA approval', 'Annual inspection', 'MLC 2006'], inspection_interval_months: 12, maritime_authority: 'China MSA', authority_website: 'https://msa.gov.cn', published: true, created_at: new Date().toISOString(), updated_at: new Date().toISOString() },
  { id: 'ru', country_name: 'Russia', country_code: 'RU', flag_emoji: '🇷🇺', paris_mou_status: 'grey', paris_mou_rank: 47, slug: 'russia-flag-medical-requirements', excerpt: 'Russia on Grey List 2024 (#47). Dropped from White List (#36).', content: '# Russia Flag Medical Requirements\n\nGrey List 2024 (#47) - Dropped from White List.\n\n## Maritime Authority\n**Russian Maritime Register of Shipping**\n\n## Requirements\n- Russian Maritime Register certification\n- Annual inspection\n- MLC 2006 compliance', medical_categories: ['A', 'B', 'C'], key_requirements: ['RMR approval', 'Annual inspection', 'MLC 2006'], inspection_interval_months: 12, maritime_authority: 'Russian Maritime Register', published: true, created_at: new Date().toISOString(), updated_at: new Date().toISOString() },
  { id: 'tr', country_name: 'Turkey', country_code: 'TR', flag_emoji: '🇹🇷', paris_mou_status: 'grey', paris_mou_rank: 48, slug: 'turkey-flag-medical-requirements', excerpt: 'Turkey on Grey List 2024 (#48). Turkish Maritime Administration oversight.', content: '# Turkey Flag Medical Requirements\n\nGrey List 2024 (#48) - Average performance.\n\n## Maritime Authority\n**Turkish Maritime Administration**\n\n## Requirements\n- Turkish Maritime approval\n- Annual inspection\n- MLC 2006 compliance', medical_categories: ['A', 'B', 'C'], key_requirements: ['Turkish Maritime', 'Annual inspection', 'MLC 2006'], inspection_interval_months: 12, maritime_authority: 'Turkish Maritime Administration', published: true, created_at: new Date().toISOString(), updated_at: new Date().toISOString() },
  { id: 'in', country_name: 'India', country_code: 'IN', flag_emoji: '🇮🇳', paris_mou_status: 'grey', paris_mou_rank: 49, slug: 'india-flag-medical-requirements', excerpt: 'India on Grey List 2024 (#49). DG Shipping sets requirements.', content: '# India Flag Medical Requirements\n\nGrey List 2024 (#49) - Average performance.\n\n## Maritime Authority\n**Directorate General of Shipping**\nWebsite: https://dgshipping.gov.in\n\n## Requirements\n- DG Shipping approval\n- Annual inspection\n- MLC 2006 compliance', medical_categories: ['A', 'B', 'C'], key_requirements: ['DG Shipping', 'Annual inspection', 'MLC 2006'], inspection_interval_months: 12, maritime_authority: 'DG Shipping India', authority_website: 'https://dgshipping.gov.in', published: true, created_at: new Date().toISOString(), updated_at: new Date().toISOString() },
  { id: 'dz', country_name: 'Algeria', country_code: 'DZ', flag_emoji: '🇩🇿', paris_mou_status: 'grey', paris_mou_rank: 53, slug: 'algeria-flag-medical-requirements', excerpt: 'Algeria on Grey List 2024 (#53). Improved from Black List (#63).', content: '# Algeria Flag Medical Requirements\n\nGrey List 2024 (#53) - Improved performance, moved up from Black List.\n\n## Maritime Authority\n**Algerian Maritime Administration**\n\n## Requirements\n- Annual inspection\n- MLC 2006 compliance', medical_categories: ['A', 'B', 'C'], key_requirements: ['Annual inspection', 'MLC 2006'], inspection_interval_months: 12, maritime_authority: 'Algerian Maritime Administration', published: true, created_at: new Date().toISOString(), updated_at: new Date().toISOString() },
  // BLACK LIST 2024 - 12 flag states categorized by risk level
  // Medium Risk
  { id: 'kn', country_name: 'Saint Kitts and Nevis', country_code: 'KN', flag_emoji: '🇰🇳', paris_mou_status: 'black', paris_mou_rank: 58, slug: 'saint-kitts-nevis-flag-medical-requirements', excerpt: 'Saint Kitts and Nevis on Black List 2024 (Medium Risk). Dropped from Grey List.', content: '# Saint Kitts and Nevis Flag Medical Requirements\n\n⚠️ BLACK LIST 2024 - Medium Risk\n\nDropped from Grey List (#59) to Black List (#58) in 2024.\n\n## Warning\nVessels may face additional inspections and potential banning in Paris MOU ports.', medical_categories: ['A', 'B', 'C'], key_requirements: ['Subject to enhanced PSC inspections', 'Potential banning measures'], inspection_interval_months: 12, maritime_authority: 'St Kitts and Nevis Maritime', published: true, created_at: new Date().toISOString(), updated_at: new Date().toISOString() },
  { id: 'tg', country_name: 'Togo', country_code: 'TG', flag_emoji: '🇹🇬', paris_mou_status: 'black', paris_mou_rank: 59, slug: 'togo-flag-medical-requirements', excerpt: 'Togo on Black List 2024 (Medium Risk).', content: '# Togo Flag Medical Requirements\n\n⚠️ BLACK LIST 2024 - Medium Risk\n\n## Warning\nVessels may face additional inspections and potential banning.', medical_categories: ['A', 'B', 'C'], key_requirements: ['Subject to enhanced PSC inspections'], inspection_interval_months: 12, maritime_authority: 'Togo Maritime', published: true, created_at: new Date().toISOString(), updated_at: new Date().toISOString() },
  { id: 'pw', country_name: 'Palau', country_code: 'PW', flag_emoji: '🇵🇼', paris_mou_status: 'black', paris_mou_rank: 60, slug: 'palau-flag-medical-requirements', excerpt: 'Palau on Black List 2024 (Medium Risk).', content: '# Palau Flag Medical Requirements\n\n⚠️ BLACK LIST 2024 - Medium Risk\n\n## Warning\nVessels may face additional inspections and potential banning.', medical_categories: ['A', 'B', 'C'], key_requirements: ['Subject to enhanced PSC inspections'], inspection_interval_months: 12, maritime_authority: 'Palau Maritime', published: true, created_at: new Date().toISOString(), updated_at: new Date().toISOString() },
  { id: 'gw', country_name: 'Guinea-Bissau', country_code: 'GW', flag_emoji: '🇬🇼', paris_mou_status: 'black', paris_mou_rank: 61, slug: 'guinea-bissau-flag-medical-requirements', excerpt: 'Guinea-Bissau NEW on Black List 2024 (Medium Risk).', content: '# Guinea-Bissau Flag Medical Requirements\n\n⚠️ BLACK LIST 2024 - Medium Risk\n\n**NEW** to Black List in 2024.\n\n## Warning\nVessels may face additional inspections and potential banning.', medical_categories: ['A', 'B', 'C'], key_requirements: ['Subject to enhanced PSC inspections'], inspection_interval_months: 12, maritime_authority: 'Guinea-Bissau Maritime', published: true, created_at: new Date().toISOString(), updated_at: new Date().toISOString() },
  // Medium to High Risk
  { id: 'bz', country_name: 'Belize', country_code: 'BZ', flag_emoji: '🇧🇿', paris_mou_status: 'black', paris_mou_rank: 62, slug: 'belize-flag-medical-requirements', excerpt: 'Belize on Black List 2024 (Medium to High Risk).', content: '# Belize Flag Medical Requirements\n\n⚠️ BLACK LIST 2024 - Medium to High Risk\n\n## Warning\nVessels subject to enhanced inspections. Potential refusal of access to Paris MOU ports.', medical_categories: ['A', 'B', 'C'], key_requirements: ['Subject to enhanced PSC inspections', 'Potential port access refusal'], inspection_interval_months: 12, maritime_authority: 'Belize Port Authority', published: true, created_at: new Date().toISOString(), updated_at: new Date().toISOString() },
  { id: 'vu', country_name: 'Vanuatu', country_code: 'VU', flag_emoji: '🇻🇺', paris_mou_status: 'black', paris_mou_rank: 63, slug: 'vanuatu-flag-medical-requirements', excerpt: 'Vanuatu on Black List 2024 (Medium to High Risk).', content: '# Vanuatu Flag Medical Requirements\n\n⚠️ BLACK LIST 2024 - Medium to High Risk\n\n## Warning\nVessels subject to enhanced inspections. Potential refusal of access.', medical_categories: ['A', 'B', 'C'], key_requirements: ['Subject to enhanced PSC inspections', 'Potential port access refusal'], inspection_interval_months: 12, maritime_authority: 'Vanuatu Maritime', published: true, created_at: new Date().toISOString(), updated_at: new Date().toISOString() },
  { id: 'ua', country_name: 'Ukraine', country_code: 'UA', flag_emoji: '🇺🇦', paris_mou_status: 'black', paris_mou_rank: 64, slug: 'ukraine-flag-medical-requirements', excerpt: 'Ukraine on Black List 2024 (Medium to High Risk).', content: '# Ukraine Flag Medical Requirements\n\n⚠️ BLACK LIST 2024 - Medium to High Risk\n\n## Warning\nVessels subject to enhanced inspections. Potential refusal of access.', medical_categories: ['A', 'B', 'C'], key_requirements: ['Subject to enhanced PSC inspections', 'Potential port access refusal'], inspection_interval_months: 12, maritime_authority: 'Maritime Administration of Ukraine', published: true, created_at: new Date().toISOString(), updated_at: new Date().toISOString() },
  // High Risk
  { id: 'km', country_name: 'Comoros', country_code: 'KM', flag_emoji: '🇰🇲', paris_mou_status: 'black', paris_mou_rank: 65, slug: 'comoros-flag-medical-requirements', excerpt: 'Comoros on Black List 2024 (High Risk). Only country in this category.', content: '# Comoros Flag Medical Requirements\n\n⚠️ BLACK LIST 2024 - High Risk\n\nOnly flag state in the High Risk category.\n\n## Warning\nVessels subject to priority inspections and potential banning from Paris MOU ports.', medical_categories: ['A', 'B', 'C'], key_requirements: ['Priority PSC inspections', 'High banning risk'], inspection_interval_months: 12, maritime_authority: 'Comoros Maritime', published: true, created_at: new Date().toISOString(), updated_at: new Date().toISOString() },
  // Very High Risk (worst performers)
  { id: 'vn', country_name: 'Vietnam', country_code: 'VN', flag_emoji: '🇻🇳', paris_mou_status: 'black', paris_mou_rank: 66, slug: 'vietnam-flag-medical-requirements', excerpt: 'Vietnam on Black List 2024 (Very High Risk). 43 inspections, 12 detentions.', content: '# Vietnam Flag Medical Requirements\n\n⚠️ BLACK LIST 2024 - Very High Risk\n\n2022-2024 Statistics: 43 inspections, 12 detentions\n\n## Warning\nVessels face mandatory expanded inspections. High likelihood of detention and banning.', medical_categories: ['A', 'B', 'C'], key_requirements: ['Mandatory expanded inspections', 'Very high detention risk'], inspection_interval_months: 12, maritime_authority: 'Vietnam Maritime Administration', published: true, created_at: new Date().toISOString(), updated_at: new Date().toISOString() },
  { id: 'md', country_name: 'Moldova', country_code: 'MD', flag_emoji: '🇲🇩', paris_mou_status: 'black', paris_mou_rank: 67, slug: 'moldova-flag-medical-requirements', excerpt: 'Moldova on Black List 2024 (Very High Risk). 32 inspections, 10 detentions.', content: '# Moldova Flag Medical Requirements\n\n⚠️ BLACK LIST 2024 - Very High Risk\n\n2022-2024 Statistics: 32 inspections, 10 detentions\n\n## Warning\nVessels face mandatory expanded inspections. High likelihood of detention and banning.', medical_categories: ['A', 'B', 'C'], key_requirements: ['Mandatory expanded inspections', 'Very high detention risk'], inspection_interval_months: 12, maritime_authority: 'Moldova Naval Agency', published: true, created_at: new Date().toISOString(), updated_at: new Date().toISOString() },
  { id: 'tz', country_name: 'Tanzania', country_code: 'TZ', flag_emoji: '🇹🇿', paris_mou_status: 'black', paris_mou_rank: 68, slug: 'tanzania-flag-medical-requirements', excerpt: 'Tanzania on Black List 2024 (Very High Risk). 149 inspections, 41 detentions.', content: '# Tanzania Flag Medical Requirements\n\n⚠️ BLACK LIST 2024 - Very High Risk\n\n2022-2024 Statistics: 149 inspections, 41 detentions\n\n## Warning\nVessels face mandatory expanded inspections. High likelihood of detention and banning.', medical_categories: ['A', 'B', 'C'], key_requirements: ['Mandatory expanded inspections', 'Very high detention risk'], inspection_interval_months: 12, maritime_authority: 'Tanzania Maritime Authority', published: true, created_at: new Date().toISOString(), updated_at: new Date().toISOString() },
  { id: 'cm', country_name: 'Cameroon', country_code: 'CM', flag_emoji: '🇨🇲', paris_mou_status: 'black', paris_mou_rank: 69, slug: 'cameroon-flag-medical-requirements', excerpt: 'Cameroon ranks LAST (#69) on Paris MOU 2024 (Very High Risk). 144 inspections, 43 detentions. Worst performer for several years.', content: '# Cameroon Flag Medical Requirements\n\n⚠️ BLACK LIST 2024 - Very High Risk (WORST)\n\nRanks LAST (#69) on Paris MOU 2024. Worst performer for several consecutive years.\n\n2022-2024 Statistics: 144 inspections, 43 detentions\n\n## Warning\nVessels face mandatory expanded inspections with near-certain detention and banning.', medical_categories: ['A', 'B', 'C'], key_requirements: ['Mandatory expanded inspections', 'Near-certain detention', 'Banning likely'], inspection_interval_months: 12, maritime_authority: 'Cameroon Maritime', published: true, created_at: new Date().toISOString(), updated_at: new Date().toISOString() },
];
