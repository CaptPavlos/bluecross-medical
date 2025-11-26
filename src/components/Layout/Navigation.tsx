import { useIsMobile } from '../../hooks';
import Header from './Header';
import MobileNav from './MobileNav';

function Navigation() {
  const isMobile = useIsMobile();

  return (
    <>
      <Header />
      {isMobile && <MobileNav />}
    </>
  );
}

export default Navigation;
