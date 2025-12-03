-- Insert mock blog posts into the database
-- Run this migration in your Neon database console

INSERT INTO blog_posts (title, slug, content, excerpt, featured_image_url, author_name, published, published_at, tags, reading_time_minutes, created_at, updated_at)
VALUES
(
  'What is the M.A.C. and why it matters?',
  'what-is-the-mac-and-why-it-matters',
  'Medical Advice Center (MAC) of Hellenic Red Cross was established by law in November 1987 and is included in the network of total five (5) Medical Advice Centers established in France, Italy, Greece, Spain and Portugal. The Greek Center moved to Henry Dunant Hospital in 2009.

MAC operates on a 24/7 basis, with the direct support of Henry Dunant Hospital''s doctors, offering medical advice to any emergency that may occur to passengers and crews onboard commercial or other vessels in all seas around the world, without distinction on the flag ship or nationality.

In 34 years of operation, MAC''s work has been recognized by sailors and based on the high levels of services offered naval family has developed absolute confidence.

Capabilities of MAC include:
- Direct telephone communication from anywhere in the world via satellite, coastal telecommunications network "Olympia Radio" or Hellenic Coast Guard Operation Center.
- Image Transfer via Internet (e-mail) for more complete information of Physicians, direct and easier response to incidents.
- Response to incidents (injuries, minor illnesses, minor burns etc.) taking into account the limitation of the pharmaceutical and hospital instruments of ships.
- For incidents that cannot be addressed on board, relevant advice is given to the master in order to make diversion of the ship to the nearest port.

Emergency numbers: +30 210 523 0880 / +30 210 523 7515

Safe seas!',
  'Medical Advice Center (MAC) of Hellenic Red Cross operates 24/7, offering medical advice to any emergency onboard vessels worldwide.',
  'https://images.spr.so/cdn-cgi/imagedelivery/j42No7y-dcokJuNgXeA0ig/c06cac5e-9405-449f-82f6-dbf89c591715/MAC_Blog_Cover/w=800,quality=90,fit=scale-down',
  'BlueCross Medical',
  true,
  '2024-01-15T10:00:00Z',
  ARRAY['MAC', 'Hellenic Red Cross', 'Emergency', 'Maritime'],
  4,
  NOW(),
  NOW()
),
(
  'What medicines can be found in a ship''s medical chest?',
  'ships-medical-chest-medicines',
  'Every ship in the world carries an inventory of medicines (termed "medical chest"). What is inside that inventory depends on the regulations of each vessel''s Flag state. Usually, there is a distinction between ocean-going vessels and vessels that sail closer to the coast.

This list is not exclusive and many companies decide to add additional equipment through their company''s ISM. After all, you will notice that vital items such as a defibrillator or telemedicine monitor are absent from the "required" list.

MEDICINE CHEST CATEGORIES

The lists are typically split into 3 categories:

CATEGORY 1: CONTROLLED SUBSTANCES (NARCOTICS)

These medicines are deemed "narcotics" by the Flag state and must be kept in the custody of the Master, locked away from the rest of the medicine chest in a separate secure location.

Examples include:
- Morphine sulfate (injectable) - for severe pain
- Tramadol - moderate to severe pain relief
- Diazepam - for seizures and severe anxiety
- Codeine phosphate - pain relief and cough suppression

CATEGORY 2: STANDARD MEDICINES

Usually stored in the ship''s hospital or medical chest, accessible to designated medical officers.

Examples include:
- Antibiotics: Amoxicillin, Ciprofloxacin, Metronidazole
- Pain relief: Paracetamol, Ibuprofen, Aspirin
- Cardiac: GTN spray, Adrenaline, Atropine
- Gastrointestinal: Omeprazole, Loperamide, Ondansetron
- Respiratory: Salbutamol inhaler, Prednisolone
- Antihistamines: Chlorpheniramine, Hydrocortisone cream

CATEGORY 3: MEDICAL EQUIPMENT

Various equipment that the vessel needs to have for emergency response and patient care.

Examples include:
- Resuscitation equipment: Bag valve mask, airways, suction
- Wound care: Sutures, dressings, splints
- Diagnostic: Stethoscope, blood pressure monitor, thermometer
- IV supplies: Cannulas, giving sets, fluids',
  'Every ship carries a medical chest. Learn what medicines are required by different Flag states and how to maintain compliance.',
  'https://images.spr.so/cdn-cgi/imagedelivery/j42No7y-dcokJuNgXeA0ig/fbdb23ed-2e95-45ef-bd67-f445c387c3b1/What_medicines_can_be_found_in_a_ships_medical_chest/w=800,quality=90,fit=scale-down',
  'BlueCross Medical',
  true,
  '2024-01-10T14:00:00Z',
  ARRAY['Medical Chest', 'Regulations', 'Maritime', 'Flag State'],
  6,
  NOW(),
  NOW()
),
(
  'Why Every Vessel Needs a Defibrillator',
  'why-every-vessel-needs-defibrillator',
  'Investing in an AED is a giant step forward because it can increase the chance of survival for witnessed Cardiac Arrest up to 85%.

Not investing in an AED means that in case of a cardiac arrest, when in the high seas, most likely the crew member will die as it not humanly possible to continue CPR indefinitely.

About 70% of all CPR is ineffectively performed, so devices like the HeartSine Samaritan 500P Defibrillator contain technology that determines whether your compressions are effective. Voice prompts guide you through the process and tell you to "Push Harder" or whether you are doing "Good Compressions" during CPR – all based on real cardiac output.

Key benefits of the HeartSine 500P:
- 8-year warranty - longest in the industry
- Real-time CPR Feedback
- Lowest maintenance cost - pads and battery renewed only every 4 years
- IP56 rated for dust & moisture
- Lightweight at only 1.1kg
- Made in EU',
  'An AED can increase survival chances for cardiac arrest up to 85%. Learn why every vessel should have one onboard.',
  'https://images.spr.so/cdn-cgi/imagedelivery/j42No7y-dcokJuNgXeA0ig/7f19e4a7-df0b-4bca-abee-453050f6f9fb/DeFib_Notion_Cover/w=800,quality=90,fit=scale-down',
  'BlueCross Medical',
  true,
  '2024-01-05T09:00:00Z',
  ARRAY['Defibrillator', 'AED', 'CPR', 'Safety', 'Maritime'],
  4,
  NOW(),
  NOW()
),
(
  'The Importance of Remote ECG Monitoring at Sea',
  'importance-remote-ecg-monitoring-sea',
  'Heart disease remains one of the leading causes of death among seafarers. With crew members often working in high-stress environments, far from medical facilities, early detection of cardiac issues is critical.

Modern ECG devices like our 12-lead AI Electrocardiographer can detect over 17 types of cardiac events including Atrial Fibrillation, Ventricular Tachycardia, and other arrhythmias. With 95.2% AI accuracy trained on over 50 million data fragments, these devices provide medical-grade reports that can be transmitted remotely to shore-based physicians.

Key advantages of remote ECG monitoring:
- Early detection of cardiac abnormalities
- AI-powered analysis for immediate insights
- Remote transmission to medical professionals
- Holter monitoring capability for 24-hour assessments
- Lightweight and portable design perfect for maritime use',
  'Early detection of cardiac issues at sea can save lives. Learn how modern ECG devices are transforming maritime healthcare.',
  'https://images.spr.so/cdn-cgi/imagedelivery/j42No7y-dcokJuNgXeA0ig/26f68a92-706c-42cd-8b35-02a84c3c98d7/12-lead_Notion_Cover/w=800,quality=90,fit=scale-down',
  'BlueCross Medical',
  true,
  '2024-01-02T10:00:00Z',
  ARRAY['ECG', 'Heart Health', 'Telemedicine', 'Maritime', 'AI'],
  5,
  NOW(),
  NOW()
),
(
  'Telemedicine at Sea: The Future of Maritime Healthcare',
  'telemedicine-at-sea-future-maritime-healthcare',
  'The maritime industry is experiencing a healthcare revolution with the adoption of advanced telemedicine systems. The S3 Base Station represents the most advanced telemedicine solution specifically designed for remote maritime environments.

Features that make modern telemedicine essential:
- Works offline and transmits via low bandwidth systems like FBB
- Patented pad-free ECG technology for quick readings
- HIPAA/HDS compliant data storage
- Integration with 24/7 medical advice centers
- Digital stethoscope for remote respiratory assessment

With proper telemedicine equipment, vessels can connect with shore-based physicians in real-time, ensuring crew members receive expert medical guidance regardless of their location at sea.',
  'Modern telemedicine systems are revolutionizing healthcare delivery at sea. Discover the latest in maritime medical technology.',
  'https://images.spr.so/cdn-cgi/imagedelivery/j42No7y-dcokJuNgXeA0ig/c52c8fd3-dce9-4989-a374-49cb6534f5db/Telemedicine_Base_Station_(1)/w=800,quality=90,fit=scale-down',
  'BlueCross Medical',
  true,
  '2023-12-28T14:00:00Z',
  ARRAY['Telemedicine', 'Maritime', 'Technology', 'Healthcare', 'Remote'],
  6,
  NOW(),
  NOW()
),
(
  'Recognizing and Responding to Heart Attacks at Sea',
  'recognizing-responding-heart-attacks-at-sea',
  'Heart attacks are the leading cause of death among seafarers (30-40% of all deaths onboard). This checklist will help you recognize and respond effectively.

CHECKLIST: RECOGNIZE THE SIGNS

[ ] Chest pain or pressure lasting more than a few minutes
[ ] Pain spreading to left arm, neck, jaw, or back
[ ] Shortness of breath
[ ] Cold sweats
[ ] Nausea or vomiting
[ ] Lightheadedness or dizziness
[ ] Unusual fatigue (especially in women)

CHECKLIST: IMMEDIATE ACTIONS

1. ALERT - Call the bridge and request TMAS contact immediately
2. POSITION - Sit patient upright at 45 degrees (semi-recumbent) to reduce heart workload
3. ASPIRIN - Give 300mg aspirin to chew (ask about allergies first)
4. OXYGEN - Check SpO2 with pulse oximeter. Give oxygen if below 94%
5. REASSURE - Keep patient calm and still. Loosen tight clothing
6. MONITOR - Check pulse and breathing every 2 minutes
7. AED READY - Have defibrillator nearby in case of cardiac arrest
8. DOCUMENT - Write down time symptoms started and all actions taken

WARNING SIGNS OF CARDIAC ARREST

[ ] Patient becomes unresponsive
[ ] No normal breathing (or only gasping)
[ ] No pulse

If any of these occur, START CPR IMMEDIATELY and use AED.',
  'Step-by-step checklist for recognizing and responding to heart attacks at sea. Print and post in ship hospital.',
  'https://images.unsplash.com/photo-1576091160550-2173dba999ef?w=800&q=80',
  'BlueCross Medical',
  true,
  '2024-02-15T10:00:00Z',
  ARRAY['Heart Attack', 'Emergency', 'First Aid', 'Maritime', 'Checklist'],
  5,
  NOW(),
  NOW()
),
(
  'How to Use an AED: Step-by-Step Checklist',
  'how-to-use-aed-defibrillator-step-by-step',
  'An AED can increase survival from cardiac arrest to 85%. The device talks you through it. Follow this checklist.

CHECKLIST: WHEN TO USE AED

[ ] Person is unresponsive (does not respond when you shout and tap shoulders)
[ ] Not breathing normally (no breathing, or only occasional gasps)
[ ] No pulse (check at neck for 10 seconds maximum)

If ALL THREE are present, this is CARDIAC ARREST. Use AED immediately.

STEP-BY-STEP CHECKLIST

1. SAFETY - Check area is safe. Move patient from water if wet deck
2. CALL FOR HELP - Shout for assistance. Send someone for AED
3. START CPR - Begin chest compressions while waiting for AED
4. TURN ON AED - Press power button. Listen to voice prompts
5. BARE CHEST - Remove or cut clothing. Dry chest if wet
6. ATTACH PADS - Peel backing off pads. Place as shown on pads:
   - Right pad: Below right collarbone
   - Left pad: Left side, below armpit
7. PLUG IN - Connect pads cable to AED if not pre-connected
8. STAND CLEAR - Ensure nobody is touching patient. Say "ANALYZING"
9. FOLLOW PROMPTS - AED will say "Shock advised" or "No shock advised"
10. IF SHOCK ADVISED - Say "CLEAR!" loudly. Check nobody touching. Press shock button
11. RESUME CPR - Immediately after shock, do 30 compressions then 2 breaths
12. CONTINUE - Follow AED prompts. It will re-analyze every 2 minutes',
  'AED step-by-step checklist. The device guides you with voice prompts. Follow these steps.',
  'https://images.spr.so/cdn-cgi/imagedelivery/j42No7y-dcokJuNgXeA0ig/7f19e4a7-df0b-4bca-abee-453050f6f9fb/DeFib_Notion_Cover/w=800,quality=90,fit=scale-down',
  'BlueCross Medical',
  true,
  '2024-01-25T10:00:00Z',
  ARRAY['AED', 'Defibrillator', 'CPR', 'Cardiac Arrest', 'Checklist'],
  6,
  NOW(),
  NOW()
)
ON CONFLICT (slug) DO NOTHING;
