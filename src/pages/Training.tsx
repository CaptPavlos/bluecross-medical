/**
 * @fileoverview Training page showcasing advanced medical courses.
 */
import { motion } from 'framer-motion';
import { Link } from 'react-router-dom';
import { useState, useRef } from 'react';
import { GraduationCap, Clock, MapPin, Star, ThumbsUp, ExternalLink, Stethoscope, Heart, Shield, Anchor, Ship, AlertCircle } from 'lucide-react';
import Container from '../components/Common/Container';
import Button from '../components/Common/Button';
import { SEOHead } from '../components/SEO';

/** Advanced medical training courses that EXCEED STCW requirements */
// These courses do NOT require a medical license and go beyond standard Captain's Medical
// We do NOT list STCW courses - those are regulatory minimums
const recommendedCourses = [
  {
    id: 'wfr-maritime-sanjuan',
    title: 'Wilderness First Responder - Maritime',
    provider: 'Maritime Medical Guides',
    location: { city: 'San Juan Islands', country: 'USA', lat: 48.5343, lng: -123.0867 },
    duration: '6 days',
    certification: 'WFR + CPR/AED',
    description: 'Expedition-based WFR training aboard sailing vessels in the San Juan Archipelago. Learn wilderness medicine skills specific to the marine environment through hands-on scenarios at sea.',
    whyWeRecommend: 'Unique sailing expedition format. Real maritime scenarios. Includes camping and sailing.',
    level: 'Advanced',
    icon: Anchor,
    rating: 4.9,
    totalRatings: 67,
    website: 'https://www.maritimemedicalguides.org/wilderness-first-responder-maritime',
  },
  {
    id: 'offshore-emergency-wma',
    title: 'Offshore Emergency Medicine',
    provider: 'WMA International (Wilderness Medical Associates)',
    location: { city: 'Various US Locations', country: 'USA', lat: 42.3601, lng: -71.0589 },
    duration: '3 days + 12hr pre-course',
    certification: 'OEM Certificate',
    description: 'Prepares voyaging sailors and professional mariners to prevent and treat injuries in the most remote wilderness on earth. Includes wound care, splinting, extrication, and injections.',
    whyWeRecommend: 'Industry gold standard. Practical vessel-based training. USCG approved.',
    level: 'Advanced',
    icon: Ship,
    rating: 4.8,
    totalRatings: 156,
    website: 'https://wildmed.com/courses/specialized/offshore-emergency-medicine/',
  },
  {
    id: 'rmr-level1',
    title: 'Remote Medical Responder Level 1',
    provider: 'Endeavour Medical',
    location: { city: 'Various UK Locations', country: 'UK', lat: 51.5074, lng: -0.1278 },
    duration: '2 days',
    certification: 'RMR L1 + POMs Governance',
    description: 'Designed for those traveling to remote locations. Covers CPR, wound management, fractures, environmental illness, and prescription-only medicines training.',
    whyWeRecommend: 'UK-based with international recognition. Includes POMs governance certificate.',
    level: 'Intermediate',
    icon: Stethoscope,
    rating: 4.7,
    totalRatings: 89,
    website: 'https://www.endeavourmedical.co.uk/remote-medical-responder',
  },
  {
    id: 'rmr-level2',
    title: 'Remote Medical Responder Level 2',
    provider: 'Endeavour Medical',
    location: { city: 'Various UK Locations', country: 'UK', lat: 52.4862, lng: -1.8904 },
    duration: '4 days',
    certification: 'RMR L2 + Advanced Techniques',
    description: 'For prolonged care in remote settings. Advanced techniques including local anaesthetic, IM injections, fluid prescribing, and controlled drugs management.',
    whyWeRecommend: 'Goes far beyond STCW. Teaches invasive techniques legally. Perfect for expedition yachts.',
    level: 'Advanced',
    icon: Stethoscope,
    rating: 4.8,
    totalRatings: 52,
    website: 'https://www.endeavourmedical.co.uk/remote-medical-responder',
  },
  {
    id: 'nols-wfr',
    title: 'Wilderness First Responder',
    provider: 'NOLS Wilderness Medicine',
    location: { city: 'Multiple Locations', country: 'USA', lat: 43.4799, lng: -110.7624 },
    duration: '9-10 days',
    certification: 'NOLS WFR',
    description: 'The gold standard for outdoor professionals. Comprehensive training in patient assessment, trauma, and medical emergencies in remote environments.',
    whyWeRecommend: 'Most recognized wilderness medicine cert globally. Excellent for offshore sailors.',
    level: 'Advanced',
    icon: Shield,
    rating: 4.9,
    totalRatings: 423,
    website: 'https://www.nols.edu/wilderness-medicine/courses/',
  },
  {
    id: 'advanced-fa-mariners',
    title: 'Advanced First Aid/CPR for Mariners',
    provider: 'Backcountry Medical Guides',
    location: { city: 'California & Washington', country: 'USA', lat: 37.7749, lng: -122.4194 },
    duration: '18 hours',
    certification: 'World Sailing Recognized',
    description: 'Maritime-specific advanced first aid recognized by World Sailing. Covers marine-specific scenarios, hypothermia, drowning, and offshore emergencies.',
    whyWeRecommend: 'World Sailing recognized. Perfect for racing crews and offshore passages.',
    level: 'Intermediate',
    icon: Heart,
    rating: 4.6,
    totalRatings: 78,
    website: 'https://www.backcountrymedicalguides.org/maritime-medicine',
  },
  {
    id: 'nols-wafa',
    title: 'Wilderness Advanced First Aid',
    provider: 'NOLS Wilderness Medicine',
    location: { city: 'Multiple Locations', country: 'USA', lat: 40.7128, lng: -74.0060 },
    duration: '5 days',
    certification: 'NOLS WAFA',
    description: 'Bridge course between basic first aid and WFR. Ideal for sailors who want more than basic training but cannot commit to full WFR.',
    whyWeRecommend: 'Perfect middle ground. More practical than STCW, less time than full WFR.',
    level: 'Intermediate',
    icon: Shield,
    rating: 4.7,
    totalRatings: 198,
    website: 'https://www.nols.edu/wilderness-medicine/courses/',
  },
  {
    id: 'corom-remt',
    title: 'Remote Emergency Medical Technician (REMT)',
    provider: 'College of Remote & Offshore Medicine (CoROM)',
    location: { city: 'Malta', country: 'Malta', lat: 35.9375, lng: 14.3754 },
    duration: '75hr online + 6 days classroom',
    certification: 'MFHEA Accredited REMT',
    description: 'Industry-leading REMT program covering patient assessment, trauma, pharmacology, prolonged field care, and tropical medicine. Hybrid format with hands-on training in Malta.',
    whyWeRecommend: 'Gold standard for remote medics. Includes IBSC Tactical Responder eligibility. Malta accredited.',
    level: 'Advanced',
    icon: Stethoscope,
    rating: 4.9,
    totalRatings: 89,
    website: 'https://corom.edu.mt/remt/',
  },
  {
    id: 'ronin-frec3-sa',
    title: 'FREC Level 3 - First Response Emergency Care',
    provider: 'Ronin SA',
    location: { city: 'South Africa', country: 'South Africa', lat: -33.9249, lng: 18.4241 },
    duration: '5 days',
    certification: 'Qualsafe FREC3 (UK)',
    description: 'UK-accredited FREC3 qualification delivered in South Africa. Covers trauma, medical emergencies, and patient assessment to pre-hospital care standards.',
    whyWeRecommend: 'UK qualification in Africa. Combines with close protection training. Excellent facilities.',
    level: 'Intermediate',
    icon: Shield,
    rating: 4.7,
    totalRatings: 64,
    website: 'https://ronin.co.za/frec4',
  },
  {
    id: 'ronin-frec3-poland',
    title: 'FREC Level 3 - First Response Emergency Care',
    provider: 'Ronin Europe Ltd (Poland)',
    location: { city: 'Poland', country: 'Poland', lat: 52.2297, lng: 21.0122 },
    duration: '5 days',
    certification: 'Qualsafe FREC3 (UK)',
    description: 'UK-accredited FREC3 delivered in Poland. Same high standards as Malta courses with European accessibility.',
    whyWeRecommend: 'Central European location. Lower cost of living. UK qualification.',
    level: 'Intermediate',
    icon: Heart,
    rating: 4.6,
    totalRatings: 28,
    website: 'https://www.ronin.mt/',
  },
];

function Training() {
  const [selectedCourse, setSelectedCourse] = useState<string | null>(null);
  const [userRatings, setUserRatings] = useState<Record<string, number>>({});
  const mapRef = useRef<HTMLDivElement>(null);
  
  // Map pan/drag state
  const [mapOffset, setMapOffset] = useState({ x: 0, y: 0 });
  const [isDragging, setIsDragging] = useState(false);
  const [dragStart, setDragStart] = useState({ x: 0, y: 0 });
  
  const handleMapMouseDown = (e: React.MouseEvent) => {
    if ((e.target as HTMLElement).closest('button')) return; // Don't drag when clicking markers
    setIsDragging(true);
    setDragStart({ x: e.clientX - mapOffset.x, y: e.clientY - mapOffset.y });
  };
  
  const handleMapMouseMove = (e: React.MouseEvent) => {
    if (!isDragging) return;
    const newX = e.clientX - dragStart.x;
    const newY = e.clientY - dragStart.y;
    // Limit panning range
    setMapOffset({
      x: Math.max(-200, Math.min(200, newX)),
      y: Math.max(-100, Math.min(100, newY)),
    });
  };
  
  const handleMapMouseUp = () => {
    setIsDragging(false);
  };
  
  const handleMapMouseLeave = () => {
    setIsDragging(false);
  };

  const handleRate = (courseId: string, rating: number) => {
    setUserRatings(prev => ({ ...prev, [courseId]: rating }));
    // In production, this would send to backend
  };

  const renderStars = (rating: number, courseId: string, interactive: boolean = false) => {
    const userRating = userRatings[courseId];
    return (
      <div className="flex items-center gap-1">
        {[1, 2, 3, 4, 5].map((star) => (
          <button
            key={star}
            onClick={() => interactive && handleRate(courseId, star)}
            disabled={!interactive || userRating !== undefined}
            className={`${interactive ? 'cursor-pointer hover:scale-110' : 'cursor-default'} transition-transform`}
          >
            <Star
              size={interactive ? 20 : 14}
              className={`${
                star <= (userRating || rating)
                  ? 'fill-yellow-400 text-yellow-400'
                  : 'text-gray-300'
              }`}
            />
          </button>
        ))}
      </div>
    );
  };


  return (
    <main className="flex-1">
      <SEOHead 
        title="Maritime Medical Training Courses"
        description="Advanced medical training courses for yacht crew and maritime professionals. Wilderness First Responder, Offshore Emergency Medicine, FREC, and more. Courses worldwide."
        url="/training"
        keywords={['maritime medical training', 'yacht crew medical course', 'offshore emergency medicine', 'wilderness first responder', 'FREC maritime', 'superyacht medical training']}
      />
      
      {/* Hero */}
      <section className="pt-24 pb-12 md:pt-28 md:pb-16 bg-gradient-to-br from-brand-navy to-brand-blue">
        <Container>
          <motion.div
            initial={{ opacity: 0, y: 20 }}
            animate={{ opacity: 1, y: 0 }}
            className="text-center"
          >
            <div className="inline-flex items-center gap-2 bg-white/10 px-4 py-2 rounded-full mb-4">
              <GraduationCap className="w-5 h-5 text-brand-sky" />
              <span className="text-sm text-brand-sky-light">Beyond STCW Requirements</span>
            </div>
            <h1 className="text-3xl md:text-4xl font-bold text-white mb-4">
              Advanced Medical Training
            </h1>
            <p className="text-lg text-brand-sky-light max-w-2xl mx-auto">
              Courses that go beyond standard STCW requirements. No medical license needed.
              These programs are recommended by our team for seafarers who want real skills, not just certificates.
            </p>
          </motion.div>
        </Container>
      </section>

      {/* Important Notice */}
      <section className="py-4 bg-amber-50 border-b border-amber-200">
        <Container>
          <div className="flex items-center gap-3 text-amber-800">
            <AlertCircle size={20} className="flex-shrink-0" />
            <p className="text-sm">
              <strong>Note:</strong> We do not list STCW courses (Elementary First Aid, Medical First Aid, Medical Care). 
              Those are regulatory minimums available at any maritime training center. The courses below exceed those requirements.
            </p>
          </div>
        </Container>
      </section>

      {/* Map Section - ESRI Basemap */}
      <section className="py-8 bg-white border-b border-gray-100">
        <Container>
          <div 
            className={`relative rounded-xl overflow-hidden shadow-lg ${isDragging ? 'cursor-grabbing' : 'cursor-grab'}`}
            style={{ height: '350px' }} 
            ref={mapRef}
            onMouseDown={handleMapMouseDown}
            onMouseMove={handleMapMouseMove}
            onMouseUp={handleMapMouseUp}
            onMouseLeave={handleMapMouseLeave}
          >
            {/* Light blue ocean background fallback */}
            <div className="absolute inset-0 bg-[#b5d0d0]" />
            {/* ESRI World Ocean Basemap - Full size, no offset */}
            <div 
              className="absolute inset-0 transition-transform duration-75"
              style={{ 
                transform: `translate(${mapOffset.x}px, ${mapOffset.y}px)`,
              }}
            >
              <img 
                src="https://services.arcgisonline.com/arcgis/rest/services/Ocean/World_Ocean_Base/MapServer/export?bbox=-160,-50,160,70&bboxSR=4326&size=2000,600&format=png&f=image"
                alt="Training Locations Map"
                className="w-full h-full object-cover select-none pointer-events-none"
                draggable={false}
              />
            </div>
            {/* Location Markers */}
            <div 
              className="absolute inset-0 transition-transform duration-75"
              style={{ transform: `translate(${mapOffset.x}px, ${mapOffset.y}px)` }}
            >
              {recommendedCourses.map((course, index) => {
                // Map bbox: -160,-50,160,70 (lng_min, lat_min, lng_max, lat_max)
                // Adjusted based on visual inspection of the map
                const positions: Record<string, { top: string; left: string }> = {
                  // US courses - move right onto US landmass
                  'wfr-maritime-sanjuan': { top: '18%', left: '18%' }, // San Juan Islands, WA 
                  'offshore-emergency-wma': { top: '23%', left: '28%' }, // Boston
                  'nols-wfr': { top: '22%', left: '22%' }, // Wyoming
                  'advanced-fa-mariners': { top: '27%', left: '17%' }, // California
                  'nols-wafa': { top: '24%', left: '27%' }, // New York
                  // UK courses - move left onto UK
                  'rmr-level1': { top: '18%', left: '46%' }, // London
                  'rmr-level2': { top: '17%', left: '45%' }, // Birmingham
                  // Malta - move left to Mediterranean
                  'corom-remt': { top: '30%', left: '48%' }, // Malta (Mediterranean, south of Italy)
                  // South Africa - looks OK
                  'ronin-frec3-sa': { top: '75%', left: '52%' }, // Cape Town
                  // Poland - move left to Eastern Europe
                  'ronin-frec3-poland': { top: '18%', left: '49%' }, // Warsaw
                };
                const pos = positions[course.id] || { top: '50%', left: '50%' };
                
                const handleMarkerClick = (e: React.MouseEvent) => {
                  e.stopPropagation();
                  if (selectedCourse === course.id) {
                    // Second click - open website
                    window.open(course.website, '_blank', 'noopener,noreferrer');
                  } else {
                    // First click - select course
                    setSelectedCourse(course.id);
                  }
                };
                
                return (
                  <motion.button
                    key={course.id}
                    initial={{ scale: 0 }}
                    animate={{ scale: 1 }}
                    transition={{ delay: index * 0.1 }}
                    onClick={handleMarkerClick}
                    className={`absolute transform -translate-x-1/2 -translate-y-1/2 ${
                      selectedCourse === course.id ? 'z-30' : 'z-10'
                    }`}
                    style={{ top: pos.top, left: pos.left }}
                    title={`${course.title} - Click to select, click again to visit website`}
                  >
                    <div className={`w-8 h-8 rounded-full flex items-center justify-center shadow-lg transition-all border-2 border-white ${
                      selectedCourse === course.id 
                        ? 'bg-brand-ocean scale-125' 
                        : 'bg-red-500 hover:bg-brand-ocean'
                    }`}>
                      <MapPin size={16} className="text-white" />
                    </div>
                    {selectedCourse === course.id && (
                      <motion.div
                        initial={{ opacity: 0, y: 10 }}
                        animate={{ opacity: 1, y: 0 }}
                        className="absolute top-full mt-2 left-1/2 -translate-x-1/2 bg-white rounded-lg shadow-xl p-3 min-w-[240px] text-left z-40"
                      >
                        <p className="font-semibold text-brand-navy text-sm">{course.title}</p>
                        <p className="text-xs text-gray-500">{course.location.city}, {course.location.country}</p>
                        <p className="text-xs text-brand-ocean mt-1">{course.provider}</p>
                        <div className="flex items-center gap-1 mt-2">
                          {renderStars(course.rating, course.id)}
                          <span className="text-xs text-gray-500 ml-1">{course.rating}</span>
                        </div>
                        <p className="text-xs text-brand-ocean mt-2 font-medium flex items-center gap-1">
                          <ExternalLink size={10} />
                          Click again to visit website
                        </p>
                      </motion.div>
                    )}
                  </motion.button>
                );
              })}
            </div>
            <div className="absolute bottom-4 left-4 bg-white/95 backdrop-blur-sm rounded-lg px-3 py-2 text-xs text-gray-600 shadow pointer-events-none">
              <MapPin size={12} className="inline mr-1 text-red-500" />
              Drag to pan • Click marker to select • Click again to visit website
            </div>
            <div className="absolute bottom-4 right-4 bg-white/95 backdrop-blur-sm rounded-lg px-2 py-1 text-xs text-gray-400">
              Map: Esri Ocean Basemap
            </div>
          </div>
        </Container>
      </section>

      {/* Courses */}
      <section className="py-16 md:py-24">
        <Container>
          <motion.div
            initial={{ opacity: 0, y: 20 }}
            whileInView={{ opacity: 1, y: 0 }}
            viewport={{ once: true }}
            className="text-center mb-12"
          >
            <h2 className="text-2xl md:text-3xl font-bold text-brand-navy mb-4">
              Courses That Actually Teach You Something
            </h2>
            <p className="text-gray-600 max-w-2xl mx-auto">
              These courses go beyond regulatory checkboxes. They teach practical skills for real emergencies at sea.
              No medical license required. Rate courses anonymously to help fellow seafarers.
            </p>
          </motion.div>

          <div className="grid md:grid-cols-2 lg:grid-cols-3 gap-6">
            {recommendedCourses.map((course, index) => (
              <motion.div
                key={course.id}
                initial={{ opacity: 0, y: 30 }}
                whileInView={{ opacity: 1, y: 0 }}
                viewport={{ once: true }}
                transition={{ delay: index * 0.1 }}
                className={`bg-white rounded-xl shadow-sm border overflow-hidden hover:shadow-lg transition-all ${
                  selectedCourse === course.id ? 'border-brand-ocean ring-2 ring-brand-ocean/20' : 'border-gray-100'
                }`}
              >
                <div className="p-6">
                  <div className="flex items-start justify-between mb-4">
                    <div className="w-12 h-12 bg-brand-ocean/10 rounded-lg flex items-center justify-center">
                      <course.icon className="w-6 h-6 text-brand-ocean" />
                    </div>
                    <span className={`text-xs font-medium px-3 py-1 rounded-full ${
                      course.level === 'Advanced' ? 'bg-red-100 text-red-700' :
                      course.level === 'Intermediate' ? 'bg-yellow-100 text-yellow-700' :
                      'bg-green-100 text-green-700'
                    }`}>
                      {course.level}
                    </span>
                  </div>
                  
                  <h3 className="text-lg font-semibold text-brand-navy mb-1">{course.title}</h3>
                  <p className="text-sm text-brand-ocean font-medium mb-2">{course.provider}</p>
                  <p className="text-sm text-gray-600 mb-4">{course.description}</p>
                  
                  {/* Location & Duration */}
                  <div className="flex items-center gap-4 text-sm text-gray-500 mb-4">
                    <span className="flex items-center gap-1">
                      <MapPin size={14} />
                      {course.location.city}
                    </span>
                    <span className="flex items-center gap-1">
                      <Clock size={14} />
                      {course.duration}
                    </span>
                  </div>

                  {/* Why We Recommend */}
                  <div className="bg-brand-ocean/5 rounded-lg p-3 mb-4">
                    <p className="text-xs font-medium text-brand-ocean mb-1 flex items-center gap-1">
                      <ThumbsUp size={12} />
                      Why we recommend
                    </p>
                    <p className="text-xs text-gray-600">{course.whyWeRecommend}</p>
                  </div>

                  {/* Rating */}
                  <div className="border-t border-gray-100 pt-4">
                    <div className="flex items-center justify-between mb-2">
                      <div className="flex items-center gap-2">
                        {renderStars(course.rating, course.id)}
                        <span className="text-sm font-medium text-gray-700">{course.rating}</span>
                        <span className="text-xs text-gray-400">({course.totalRatings} ratings)</span>
                      </div>
                    </div>
                    
                    {/* User Rating */}
                    {!userRatings[course.id] ? (
                      <div className="mt-3">
                        <p className="text-xs text-gray-500 mb-1">Rate this course:</p>
                        {renderStars(0, course.id, true)}
                      </div>
                    ) : (
                      <p className="text-xs text-green-600 mt-2">
                        ✓ Thanks for your rating!
                      </p>
                    )}
                  </div>

                  {/* Link */}
                  <a
                    href={course.website}
                    target="_blank"
                    rel="noopener noreferrer"
                    className="mt-4 flex items-center gap-2 text-sm text-brand-ocean hover:underline"
                  >
                    Visit provider website
                    <ExternalLink size={14} />
                  </a>
                </div>
              </motion.div>
            ))}
          </div>
        </Container>
      </section>

      {/* CTA */}
      <section className="py-16 md:py-24 bg-gradient-to-br from-brand-navy to-brand-blue">
        <Container>
          <motion.div
            initial={{ opacity: 0, y: 20 }}
            whileInView={{ opacity: 1, y: 0 }}
            viewport={{ once: true }}
            className="text-center"
          >
            <GraduationCap className="w-12 h-12 text-brand-sky mx-auto mb-4" />
            <h2 className="text-2xl md:text-3xl font-bold text-white mb-4">
              Know a Great Course?
            </h2>
            <p className="text-brand-sky-light max-w-xl mx-auto mb-8">
              If you've attended a maritime medical training course that you'd recommend, 
              let us know! We're always looking to expand our recommendations.
            </p>
            <Link to="/contact">
              <Button size="lg">
                Suggest a Course
              </Button>
            </Link>
          </motion.div>
        </Container>
      </section>
    </main>
  );
}

export default Training;
