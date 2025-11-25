import { useState, useEffect, useRef, useCallback } from 'react';
import { ChevronLeft, ChevronRight } from 'lucide-react';
import { cn } from '../../lib/utils';

interface Feature {
  title: string;
  description: string;
  icon: React.ReactNode;
}

interface FeatureCarouselProps {
  features: Feature[];
  autoPlay?: boolean;
  interval?: number;
}

function FeatureCarousel({ features, autoPlay = true, interval = 5000 }: FeatureCarouselProps) {
  const [currentIndex, setCurrentIndex] = useState(0);
  const timerRef = useRef<ReturnType<typeof setInterval> | null>(null);

  const stopTimer = useCallback(() => {
    if (timerRef.current) {
      clearInterval(timerRef.current);
      timerRef.current = null;
    }
  }, []);

  const startTimer = useCallback(() => {
    if (autoPlay && features.length > 1) {
      timerRef.current = setInterval(() => {
        setCurrentIndex((prev) => (prev + 1) % features.length);
      }, interval);
    }
  }, [autoPlay, interval, features.length]);

  useEffect(() => {
    startTimer();
    return () => stopTimer();
  }, [startTimer, stopTimer]);

  const goToPrevious = () => {
    stopTimer();
    setCurrentIndex((prev) => (prev - 1 + features.length) % features.length);
    startTimer();
  };

  const goToNext = () => {
    stopTimer();
    setCurrentIndex((prev) => (prev + 1) % features.length);
    startTimer();
  };

  return (
    <div className="relative overflow-hidden">
      <div className="flex items-center">
        <button
          onClick={goToPrevious}
          className="absolute left-0 z-10 p-2 bg-white/80 rounded-full shadow-md hover:bg-white transition-colors"
          aria-label="Previous"
        >
          <ChevronLeft size={20} className="text-brand-slate" />
        </button>

        <div className="overflow-hidden mx-12 w-full">
          <div
            className="flex transition-transform duration-300 ease-out"
            style={{ transform: `translateX(-${currentIndex * 100}%)` }}
          >
            {features.map((feature, index) => (
              <div key={index} className="flex-shrink-0 w-full px-4">
                <div className="bg-white rounded-xl p-6 text-center shadow-sm">
                  <div className="w-16 h-16 mx-auto mb-4 bg-brand-ocean/10 rounded-full flex items-center justify-center text-brand-ocean">
                    {feature.icon}
                  </div>
                  <h3 className="text-h3 font-semibold text-brand-slate mb-2">
                    {feature.title}
                  </h3>
                  <p className="text-brand-gray">{feature.description}</p>
                </div>
              </div>
            ))}
          </div>
        </div>

        <button
          onClick={goToNext}
          className="absolute right-0 z-10 p-2 bg-white/80 rounded-full shadow-md hover:bg-white transition-colors"
          aria-label="Next"
        >
          <ChevronRight size={20} className="text-brand-slate" />
        </button>
      </div>

      {/* Dots indicator */}
      <div className="flex justify-center gap-2 mt-6">
        {features.map((_, index) => (
          <button
            key={index}
            onClick={() => {
              stopTimer();
              setCurrentIndex(index);
              startTimer();
            }}
            className={cn(
              'w-2 h-2 rounded-full transition-all',
              index === currentIndex
                ? 'bg-brand-ocean w-6'
                : 'bg-gray-300 hover:bg-gray-400'
            )}
            aria-label={`Go to slide ${index + 1}`}
          />
        ))}
      </div>
    </div>
  );
}

export default FeatureCarousel;
