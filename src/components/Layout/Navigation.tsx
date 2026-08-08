import Header from './Header';
import MobileNav from './MobileNav';

/**
 * Navigation wrapper that renders appropriate navigation for device type.
 * Shows Header on all devices, adds MobileNav bottom bar on mobile.
 */
function Navigation() {
  return (
    <>
      <Header />
      <MobileNav />
    </>
  );
}

export default Navigation;
