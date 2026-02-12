import { forwardRef } from 'react';
import { cn } from '../../lib/utils';

/**
 * Props for the FormTextarea component.
 */
interface FormTextareaProps extends React.TextareaHTMLAttributes<HTMLTextAreaElement> {
  label?: string;
  error?: string;
  helperText?: string;
}

/**
 * Accessible form textarea component with label, validation, and helper text.
 * Supports vertical resizing with minimum height.
 * @param label - Label text displayed above textarea
 * @param error - Error message to display (triggers error styling)
 * @param helperText - Helper text shown below textarea when no error
 */
const FormTextarea = forwardRef<HTMLTextAreaElement, FormTextareaProps>(
  ({ className, label, error, helperText, id, ...props }, ref) => {
    const textareaId = id || props.name;

    return (
      <div className="w-full">
        {label && (
          <label
            htmlFor={textareaId}
            className="block text-sm font-medium text-brand-slate mb-1.5"
          >
            {label}
            {props.required && <span className="text-brand-red ml-1">*</span>}
          </label>
        )}
        <textarea
          ref={ref}
          id={textareaId}
          className={cn(
            'w-full px-4 py-2.5 bg-white border rounded-lg text-brand-slate placeholder:text-brand-gray',
            'focus:outline-none focus:ring-2 focus:ring-brand-ocean/20 focus:border-brand-ocean',
            'transition-colors duration-fast resize-y min-h-[120px]',
            'disabled:bg-gray-100 disabled:cursor-not-allowed',
            error
              ? 'border-brand-red focus:ring-brand-red/20 focus:border-brand-red'
              : 'border-gray-200',
            className
          )}
          aria-invalid={error ? 'true' : 'false'}
          aria-describedby={error ? `${textareaId}-error` : undefined}
          {...props}
        />
        {error && (
          <p id={`${textareaId}-error`} className="mt-1.5 text-sm text-brand-red">
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

FormTextarea.displayName = 'FormTextarea';

export default FormTextarea;
