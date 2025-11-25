import { useState } from 'react';
import { AlertCircle, Phone, CheckCircle, Clock } from 'lucide-react';
import Modal from '../Common/Modal';
import Button from '../Common/Button';

interface SOSModalProps {
  isOpen: boolean;
  onClose: () => void;
}

type SOSStatus = 'idle' | 'confirming' | 'sending' | 'sent';

function SOSModal({ isOpen, onClose }: SOSModalProps) {
  const [status, setStatus] = useState<SOSStatus>('idle');

  const handleConfirm = () => {
    setStatus('confirming');
  };

  const handleSendSOS = () => {
    setStatus('sending');
    setTimeout(() => {
      setStatus('sent');
    }, 2000);
  };

  const handleClose = () => {
    setStatus('idle');
    onClose();
  };

  return (
    <Modal
      isOpen={isOpen}
      onClose={handleClose}
      title=""
      showCloseButton={status === 'idle'}
      closeOnOverlayClick={status === 'idle'}
      size="sm"
    >
      {status === 'idle' && (
        <div className="text-center py-4">
          <div className="w-20 h-20 bg-brand-red/10 rounded-full flex items-center justify-center mx-auto mb-4">
            <AlertCircle className="w-10 h-10 text-brand-red" />
          </div>
          <h2 className="text-h2 font-bold text-brand-slate mb-2">
            Emergency SOS
          </h2>
          <p className="text-brand-gray mb-6">
            Send an emergency alert to our care team. Use only in case of a medical emergency.
          </p>
          <Button variant="danger" size="lg" onClick={handleConfirm} className="w-full">
            Activate SOS
          </Button>
          <button
            onClick={handleClose}
            className="mt-4 text-brand-gray hover:text-brand-slate transition-colors"
          >
            Cancel
          </button>
        </div>
      )}

      {status === 'confirming' && (
        <div className="text-center py-4">
          <div className="w-20 h-20 bg-brand-yellow/10 rounded-full flex items-center justify-center mx-auto mb-4">
            <AlertCircle className="w-10 h-10 text-brand-yellow" />
          </div>
          <h2 className="text-h2 font-bold text-brand-slate mb-2">
            Confirm Emergency
          </h2>
          <p className="text-brand-gray mb-6">
            Are you sure you want to send an emergency alert? Our team will be notified immediately.
          </p>
          <div className="space-y-3">
            <Button variant="danger" size="lg" onClick={handleSendSOS} className="w-full">
              Yes, Send SOS Now
            </Button>
            <Button variant="outline" size="lg" onClick={() => setStatus('idle')} className="w-full">
              Go Back
            </Button>
          </div>
        </div>
      )}

      {status === 'sending' && (
        <div className="text-center py-8">
          <div className="w-20 h-20 bg-brand-ocean/10 rounded-full flex items-center justify-center mx-auto mb-4">
            <Clock className="w-10 h-10 text-brand-ocean animate-spin" />
          </div>
          <h2 className="text-h2 font-bold text-brand-slate mb-2">
            Sending Alert...
          </h2>
          <p className="text-brand-gray">
            Please wait while we notify our emergency team.
          </p>
        </div>
      )}

      {status === 'sent' && (
        <div className="text-center py-4">
          <div className="w-20 h-20 bg-brand-green/10 rounded-full flex items-center justify-center mx-auto mb-4">
            <CheckCircle className="w-10 h-10 text-brand-green" />
          </div>
          <h2 className="text-h2 font-bold text-brand-slate mb-2">
            Alert Sent
          </h2>
          <p className="text-brand-gray mb-6">
            Our emergency team has been notified. Someone will contact you shortly.
          </p>
          <div className="bg-surface-secondary p-4 rounded-lg mb-6">
            <div className="flex items-center justify-center space-x-2 text-brand-ocean">
              <Phone size={20} />
              <span className="font-semibold">Emergency Line: 1-800-555-CARE</span>
            </div>
          </div>
          <Button variant="primary" size="lg" onClick={handleClose} className="w-full">
            Close
          </Button>
        </div>
      )}
    </Modal>
  );
}

export default SOSModal;
