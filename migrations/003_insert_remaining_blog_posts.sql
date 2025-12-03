-- Insert remaining mock blog posts into the database
-- Run this migration in your Neon database console

INSERT INTO blog_posts (title, slug, content, excerpt, featured_image_url, author_name, published, published_at, tags, reading_time_minutes, created_at, updated_at)
VALUES
(
  'Captain Richard''s Story: Why Crew Health Monitoring Matters',
  'captain-richards-story-crew-health-monitoring',
  'Imagine Captain Richard - 20 years with your fleet, mid-fifties, two packs a day. He is currently alongside a port in China during Covid measures. At 08:00 LT, he is found unconscious and without a pulse. There is no defibrillator on board.

This scenario, while extreme, highlights the reality many shipping companies face. Heart disease is a leading cause of death at sea, and preventive monitoring can make the difference between life and death.

What if Captain Richard had access to weekly ECG monitoring through a portable Vital Signs Pro+ device? The early warning signs of cardiac issues could have been detected and addressed before a crisis occurred.

Key takeaways:
- High-risk crew members need regular monitoring
- Portable devices make monitoring feasible at sea
- Early detection saves lives and reduces costs
- P&I clubs increasingly recognize the value of preventive care',
  'A fictional but realistic scenario that illustrates the life-saving importance of crew health monitoring at sea.',
  'https://images.spr.so/cdn-cgi/imagedelivery/j42No7y-dcokJuNgXeA0ig/143ad6b6-6b0e-4f05-b803-c7086e8a796c/VSP_(1)/w=800,quality=90,fit=scale-down',
  'BlueCross Medical',
  true,
  '2023-12-20T09:00:00Z',
  ARRAY['Crew Health', 'Prevention', 'Maritime', 'Safety', 'Case Study'],
  5,
  NOW(),
  NOW()
),
(
  'Severe Allergic Reactions (Anaphylaxis): Emergency Checklist',
  'severe-allergic-reactions-anaphylaxis-at-sea',
  'Anaphylaxis can kill within minutes. This checklist will help you act fast with limited resources.

CHECKLIST: RECOGNIZE ANAPHYLAXIS

[ ] Difficulty breathing or wheezing
[ ] Swelling of tongue, throat, or lips
[ ] Widespread hives or skin flushing
[ ] Rapid or weak pulse
[ ] Dizziness or fainting
[ ] Nausea, vomiting, or abdominal pain
[ ] Sense of doom or confusion

COMMON TRIGGERS TO ASK ABOUT

[ ] Shellfish, fish, nuts, eggs, or milk
[ ] Insect sting (bee, wasp)
[ ] Medication taken recently
[ ] Latex contact

CHECKLIST: IMMEDIATE ACTIONS

1. EPINEPHRINE FIRST - This is the priority. Locate adrenaline in medical chest
2. INJECT - Give 0.5ml of 1:1000 adrenaline into OUTER THIGH muscle (through clothing if needed)
3. CALL TMAS - Get medical advice while treating
4. POSITION - Lie patient flat with legs raised. If breathing difficulty, let them sit up
5. OXYGEN - Give high-flow oxygen if available
6. MONITOR - Check breathing and pulse every minute
7. REPEAT - If no improvement after 5 minutes, give second adrenaline dose
8. ANTIHISTAMINE - Give Chlorpheniramine 10mg IM as secondary treatment

IF PATIENT BECOMES UNRESPONSIVE

[ ] Check for breathing
[ ] If not breathing normally, start CPR
[ ] Continue until help arrives or patient recovers

IMPORTANT: Symptoms can return hours later. Monitor patient for at least 6 hours.',
  'Emergency checklist for anaphylaxis. Epinephrine first, ask questions later. Every second counts.',
  'https://images.unsplash.com/photo-1584017911766-d451b3d0e843?w=800&q=80',
  'BlueCross Medical',
  true,
  '2024-02-10T14:00:00Z',
  ARRAY['Anaphylaxis', 'Allergic Reaction', 'Emergency', 'First Aid', 'Checklist'],
  5,
  NOW(),
  NOW()
),
(
  'Oxygen Administration: Quick Reference Guide',
  'oxygen-administration-at-sea-practical-guide',
  'Oxygen can save lives but must be used correctly. This guide tells you when and how to give oxygen with ship equipment.

CHECKLIST: WHEN TO GIVE OXYGEN

[ ] SpO2 reading below 94% on pulse oximeter
[ ] Difficulty breathing or shortness of breath
[ ] Chest pain (possible heart attack)
[ ] After drowning or near-drowning
[ ] Severe bleeding or shock
[ ] Carbon monoxide exposure
[ ] Unconscious patient

CHECKLIST: BEFORE STARTING

1. CHECK cylinder pressure gauge - is there enough oxygen?
2. ENSURE no smoking or flames nearby
3. SELECT correct delivery device for patient condition
4. ATTACH pulse oximeter to monitor response

DELIVERY METHOD QUICK GUIDE

NASAL CANNULA (Conscious, mild symptoms)
- Flow rate: 2-4 L/min
- Delivers: 24-35% oxygen
- Use for: Alert patients with mild breathing difficulty

FACE MASK (Conscious, moderate symptoms)
- Flow rate: 6-10 L/min (minimum 5 L/min)
- Delivers: 40-60% oxygen
- Use for: Moderate breathing difficulty

NON-REBREATHER MASK (Serious symptoms)
- Flow rate: 10-15 L/min
- Delivers: 60-90% oxygen
- Use for: Severe breathing difficulty, shock, chest pain
- CHECK: Reservoir bag must stay inflated

BAG VALVE MASK (Not breathing)
- Flow rate: 15 L/min connected to bag
- Use for: Unconscious patient not breathing
- SQUEEZE bag once every 5-6 seconds

SAFETY REMINDERS

[ ] No oil or grease on equipment
[ ] Secure cylinder to prevent falling
[ ] Monitor patient response
[ ] Document flow rate and time started',
  'Quick reference for oxygen administration. Know which device to use and at what flow rate.',
  'https://images.unsplash.com/photo-1530497610245-94d3c16cda28?w=800&q=80',
  'BlueCross Medical',
  true,
  '2024-02-05T09:00:00Z',
  ARRAY['Oxygen', 'Respiratory', 'Emergency', 'First Aid', 'Checklist'],
  5,
  NOW(),
  NOW()
),
(
  'Scabies Onboard: Identification and Treatment Checklist',
  'scabies-onboard-prevention-identification-treatment',
  'Scabies spreads fast in ship living quarters. Early identification and proper treatment prevents outbreaks.

CHECKLIST: RECOGNIZE SCABIES

[ ] Intense itching, especially at night
[ ] Small red bumps or blisters
[ ] Thin, irregular burrow tracks on skin
[ ] Symptoms in multiple crew members

COMMON LOCATIONS TO CHECK

[ ] Between fingers
[ ] Wrists and inner elbows
[ ] Armpits
[ ] Waistline and belt area
[ ] Buttocks
[ ] Genitals

Note: First infection takes 4-6 weeks for symptoms. Re-infection shows symptoms in 1-4 days.

TREATMENT CHECKLIST

1. CONTACT TMAS - Confirm diagnosis before treatment
2. ISOLATE - Keep infected person in own cabin if possible
3. TREAT PATIENT:
   - Apply Permethrin 5% cream from neck to toes
   - Cover ALL skin including between fingers, under nails
   - Leave on for 8-14 hours (overnight)
   - Wash off in shower
   - REPEAT after 7 days
4. TREAT CONTACTS - All cabin mates and close contacts, even without symptoms
5. WASH EVERYTHING:
   - All bedding, towels, clothing in HOT water (60°C minimum)
   - Items that cannot be washed: seal in plastic bag for 72 hours
6. CLEAN CABIN:
   - Vacuum mattress and furniture
   - Wipe surfaces

ALTERNATIVE IF NO PERMETHRIN

Oral Ivermectin: Single dose of 200 micrograms per kg body weight. Repeat after 7 days.

PREVENTION CHECKLIST

[ ] Regular cabin inspections
[ ] Report itching early
[ ] Do not share towels, bedding, or clothing
[ ] Screen new crew joining vessel',
  'Scabies identification and treatment checklist. Act fast to prevent shipwide outbreak.',
  'https://images.unsplash.com/photo-1584515979956-d9f6e5d09982?w=800&q=80',
  'BlueCross Medical',
  true,
  '2024-01-20T14:00:00Z',
  ARRAY['Scabies', 'Skin Conditions', 'Infectious Disease', 'Checklist'],
  5,
  NOW(),
  NOW()
),
(
  'Stroke at Sea: FAST Recognition Checklist',
  'stroke-at-sea-recognition-emergency-response',
  'Stroke kills brain cells every minute. Quick recognition and response is critical. Use this FAST checklist.

FAST CHECKLIST - CHECK ALL FOUR

[ ] F - FACE: Ask person to smile. Does one side droop?
[ ] A - ARMS: Ask to raise both arms. Does one drift down?
[ ] S - SPEECH: Ask to repeat "The sky is blue." Is it slurred or strange?
[ ] T - TIME: Note the exact time symptoms started. Call TMAS immediately.

If ANY of these are present, treat as stroke emergency.

ADDITIONAL WARNING SIGNS

[ ] Sudden severe headache (worst headache ever)
[ ] Sudden confusion or trouble understanding
[ ] Sudden vision problems in one or both eyes
[ ] Sudden trouble walking or loss of balance
[ ] Sudden numbness on one side of body

CHECKLIST: IMMEDIATE ACTIONS

1. NOTE TIME - Write down when symptoms started (critical for treatment)
2. CALL TMAS - Stroke requires urgent medical advice
3. POSITION PATIENT:
   - If conscious: Sit up with head elevated 30 degrees
   - If unconscious: Recovery position (on side)
4. CHECK AIRWAY - Ensure patient can breathe
5. MONITOR - Check breathing and pulse every 2 minutes
6. OXYGEN - Give if SpO2 below 94%
7. DO NOT GIVE ASPIRIN - Unlike heart attack, aspirin can make stroke worse
8. PREPARE FOR EVACUATION - Stroke patients need hospital urgently

WHILE WAITING FOR EVACUATION

[ ] Keep patient calm and quiet
[ ] Do not give food or water (swallowing may be affected)
[ ] Keep monitoring vital signs
[ ] Document all observations for medical team
[ ] If patient becomes unresponsive, check breathing and be ready for CPR',
  'FAST stroke recognition checklist. Face, Arms, Speech, Time. Every minute counts.',
  'https://images.unsplash.com/photo-1559757148-5c350d0d3c56?w=800&q=80',
  'BlueCross Medical',
  true,
  '2024-01-18T09:00:00Z',
  ARRAY['Stroke', 'Emergency', 'Neurological', 'First Aid', 'Checklist', 'FAST'],
  5,
  NOW(),
  NOW()
),
(
  'CPR: Step-by-Step Checklist for Seafarers',
  'cpr-step-by-step-checklist-seafarers',
  'CPR keeps blood flowing to the brain until the heart restarts. Quality compressions are more important than rescue breaths. Follow this checklist.

CHECKLIST: WHEN TO START CPR

[ ] Person is unresponsive (does not respond to shouting and shoulder tap)
[ ] Not breathing normally (no breathing, or only occasional gasps)
[ ] No pulse (check at neck for maximum 10 seconds)

If ALL THREE are present, START CPR IMMEDIATELY.

BEFORE STARTING

1. ENSURE SAFETY - Check scene is safe for you
2. CALL FOR HELP - Shout for assistance. Send someone for AED
3. POSITION PATIENT - On back, on firm surface (deck, not bed)

CPR STEP-BY-STEP

1. KNEEL beside patient at chest level
2. PLACE HANDS:
   - Find center of chest (between nipples)
   - Place heel of one hand on center of chest
   - Place other hand on top, fingers interlocked
3. POSITION YOUR BODY:
   - Arms straight, shoulders directly over hands
   - Keep your back straight
4. COMPRESS:
   - Push down HARD - at least 5cm (2 inches) deep
   - Push FAST - 100-120 compressions per minute (beat of Stayin Alive)
   - Let chest fully recoil between compressions
   - Do not lean on chest between compressions
5. COUNT: 30 compressions
6. GIVE 2 BREATHS (if trained):
   - Tilt head back, lift chin
   - Pinch nose closed
   - Seal your mouth over theirs
   - Blow for 1 second, watch chest rise
   - Give second breath
7. CONTINUE: 30 compressions, 2 breaths. Do not stop.

IF YOU ARE ALONE OR UNTRAINED

Hands-only CPR is acceptable:
- Continuous chest compressions at 100-120 per minute
- Do not stop until help arrives or patient recovers

WHEN TO STOP CPR

[ ] AED is attached and analyzing
[ ] Patient starts breathing normally
[ ] Qualified medical help takes over
[ ] You are too exhausted to continue (swap with another rescuer)',
  'CPR checklist for seafarers. Push hard, push fast, do not stop. This guide saves lives.',
  'https://images.unsplash.com/photo-1612349317150-e413f6a5b16d?w=800&q=80',
  'BlueCross Medical',
  true,
  '2024-02-20T10:00:00Z',
  ARRAY['CPR', 'Cardiac Arrest', 'Emergency', 'First Aid', 'Checklist'],
  6,
  NOW(),
  NOW()
),
(
  'Airway Obstruction: Choking Emergency Checklist',
  'airway-obstruction-choking-emergency-checklist',
  'A blocked airway can kill in minutes. This checklist covers choking and basic airway management with ship resources.

CHECKLIST: RECOGNIZE CHOKING

MILD OBSTRUCTION (can still breathe):
[ ] Coughing forcefully
[ ] Can speak or make sounds
[ ] Can breathe between coughs

SEVERE OBSTRUCTION (cannot breathe):
[ ] Cannot speak or only whispers
[ ] Cannot cough effectively
[ ] Clutching throat (universal choking sign)
[ ] Face turning blue
[ ] Making high-pitched sounds or no sound
[ ] Becoming unconscious

CHECKLIST: CONSCIOUS ADULT CHOKING

1. ASK - "Are you choking? Can you speak?"
2. IF MILD (can cough): Encourage forceful coughing. Stay with them.
3. IF SEVERE (cannot cough or speak):

BACK BLOWS:
- Stand to side and slightly behind
- Support chest with one hand
- Give 5 sharp blows between shoulder blades with heel of hand

ABDOMINAL THRUSTS (if back blows fail):
- Stand behind patient
- Make fist with one hand
- Place fist just above belly button (below ribs)
- Grasp fist with other hand
- Pull sharply inward and upward
- Give 5 thrusts

4. ALTERNATE - 5 back blows, then 5 abdominal thrusts. Repeat until object clears or patient becomes unconscious.

CHECKLIST: UNCONSCIOUS CHOKING

1. LOWER patient carefully to deck
2. CALL FOR HELP - Send for AED
3. START CPR - Begin with 30 chest compressions
4. CHECK MOUTH - Before giving breaths, look in mouth for visible object
5. REMOVE OBJECT - Only if you can see it. Use finger sweep
6. ATTEMPT BREATHS - Tilt head, lift chin, try 2 breaths
7. IF CHEST DOES NOT RISE - Reposition head and try again
8. CONTINUE CPR - 30 compressions, check mouth, 2 breaths. Repeat.',
  'Choking and airway emergency checklist. Back blows, abdominal thrusts, and basic airway management.',
  'https://images.unsplash.com/photo-1559757148-5c350d0d3c56?w=800&q=80',
  'BlueCross Medical',
  true,
  '2024-02-22T10:00:00Z',
  ARRAY['Airway', 'Choking', 'Emergency', 'First Aid', 'Checklist'],
  7,
  NOW(),
  NOW()
)
ON CONFLICT (slug) DO NOTHING;
