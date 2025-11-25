import { Link } from 'react-router-dom';
import { motion } from 'framer-motion';
import { Home, ArrowLeft } from 'lucide-react';
import Container from '../components/Common/Container';
import Button from '../components/Common/Button';

function NotFound() {
  return (
    <main className="min-h-screen flex items-center justify-center pt-20 pb-16">
      <Container size="sm">
        <motion.div
          initial={{ opacity: 0, y: 20 }}
          animate={{ opacity: 1, y: 0 }}
          className="text-center"
        >
          <div className="text-8xl md:text-9xl font-bold text-brand-ocean/20 mb-4">
            404
          </div>
          <h1 className="text-display font-bold text-brand-slate mb-4">
            Page Not Found
          </h1>
          <p className="text-lg text-brand-gray mb-8 max-w-md mx-auto">
            Sorry, we couldn't find the page you're looking for. It might have been moved or doesn't exist.
          </p>
          <div className="flex flex-col sm:flex-row gap-4 justify-center">
            <Link to="/">
              <Button size="lg" leftIcon={<Home size={18} />}>
                Go Home
              </Button>
            </Link>
            <Button
              variant="outline"
              size="lg"
              leftIcon={<ArrowLeft size={18} />}
              onClick={() => window.history.back()}
            >
              Go Back
            </Button>
          </div>
        </motion.div>
      </Container>
    </main>
  );
}

export default NotFound;
