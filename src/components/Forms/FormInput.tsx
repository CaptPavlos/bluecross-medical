import { forwardRef } from 'react';
import { cn } from '../../lib/utils';

/**
 * Props for the FormInput component.
 */
interface FormInputProps extends React.InputHTMLAttributes<HTMLInputElement> {
  label?: string;
  error?: string;
  helperText?: string;
}

/**
 * Accessible form input component with label, validation, and helper text.
 * Includes ARIA attributes for screen readers and error states.
 * @param label - Label text displayed above input
 * @param error - Error message to display (triggers error styling)
 * @param helperText - Helper text shown below input when no error
 */
const FormInput = forwardRef<HTMLInputElement, FormInputProps>(
  ({ className, label, error, helperText, id, ...props }, ref) => {
    const inputId = id || props.name;

    return (
      <div className="w-full">
        {label && (
          <label
            htmlFor={inputId}
            className="block text-sm font-medium text-brand-slate mb-1.5"
          >
            {label}
            {props.required && <span className="text-brand-red ml-1">*</span>}
          </label>
        )}
        <input
          ref={ref}
          id={inputId}
          className={cn(
            'w-full px-4 py-2.5 bg-white border rounded-lg text-brand-slate placeholder:text-brand-gray',
            'focus:outline-none focus:ring-2 focus:ring-brand-ocean/20 focus:border-brand-ocean',
            'transition-colors duration-fast',
            'disabled:bg-gray-100 disabled:cursor-not-allowed',
            error
              ? 'border-brand-red focus:ring-brand-red/20 focus:border-brand-red'
              : 'border-gray-200',
            className
          )}
          aria-invalid={error ? 'true' : 'false'}
          aria-describedby={error ? `${inputId}-error` : undefined}
          {...props}
        />
        {error && (
          <p id={`${inputId}-error`} className="mt-1.5 text-sm text-brand-red">
            {error}
          </p>
        )}
        {helperText && !error && (
          <p className="mt-1.5 text-sm text-brand-gray">{helperText}</p>
        )}
      </div>
    );
  }
);

FormInput.displayName = 'FormInput';

export default FormInput;
