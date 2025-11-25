function WaveDivider() {
  return (
    <div className="relative w-full bg-brand-navy overflow-hidden">
      {/* Animated pulse line */}
      <div className="relative h-16 flex items-center justify-center">
        {/* Center glow */}
        <div className="absolute w-full h-[1px] bg-gradient-to-r from-transparent via-brand-ocean/30 to-transparent" />
        
        {/* Animated pulse traveling left to right */}
        <div className="absolute w-full h-full overflow-hidden">
          <div className="absolute h-[2px] w-32 bg-gradient-to-r from-transparent via-brand-sky to-transparent animate-pulse-line top-1/2 -translate-y-1/2" />
        </div>
        
        {/* Second pulse with delay */}
        <div className="absolute w-full h-full overflow-hidden">
          <div 
            className="absolute h-[2px] w-24 bg-gradient-to-r from-transparent via-brand-ocean/60 to-transparent animate-pulse-line top-1/2 -translate-y-1/2"
            style={{ animationDelay: '1.5s' }}
          />
        </div>
        
        {/* Dots along the line */}
        <div className="absolute flex items-center gap-8 md:gap-12">
          {[0, 1, 2, 3, 4].map((i) => (
            <div
              key={i}
              className="w-1.5 h-1.5 rounded-full bg-brand-ocean/50 animate-pulse"
              style={{ animationDelay: `${i * 0.3}s` }}
            />
          ))}
        </div>
      </div>
    </div>
  );
}

export default WaveDivider;
