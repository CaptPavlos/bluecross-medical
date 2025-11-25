import { useState } from 'react';
import { useIsMobile } from '../../hooks';
import Header from './Header';
import MobileNav from './MobileNav';
import { SOSModal } from '../SOS';

function Navigation() {
  const isMobile = useIsMobile();
  const [isSOSOpen, setIsSOSOpen] = useState(false);

  return (
    <>
      <Header />
      {isMobile && <MobileNav onSOSClick={() => setIsSOSOpen(true)} />}
      <SOSModal isOpen={isSOSOpen} onClose={() => setIsSOSOpen(false)} />
    </>
  );
}

export default Navigation;
