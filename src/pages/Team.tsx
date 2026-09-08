import { ArrowRight, Compass, Heart, ShieldCheck, Waves } from 'lucide-react';
import { TeamGrid } from '../components/Team';
import Container from '../components/Common/Container';

const values = [
  {
    number: '01',
    icon: Heart,
    title: 'Patient first',
    description: 'Every choice begins with one question: will this help someone receive better care at sea?',
  },
  {
    number: '02',
    icon: Compass,
    title: 'Built for reality',
    description: 'We choose practical, dependable solutions that make sense onboard—not technology for its own sake.',
  },
  {
    number: '03',
    icon: ShieldCheck,
    title: 'Earned trust',
    description: 'Clear advice, honest limitations, and responsible sourcing are non-negotiable.',
  },
];

/** The people, experience, and operating principles behind BlueCross Medical. */
function Team() {
  return (
    <main className="flex-1 overflow-hidden bg-white">
      <section className="relative bg-brand-navy pb-24 pt-32 text-white md:pb-32 md:pt-40">
        <div className="absolute -right-40 top-24 h-[34rem] w-[34rem] rounded-full border border-brand-sky/10" aria-hidden="true" />
        <div className="absolute -right-20 top-44 h-[22rem] w-[22rem] rounded-full border border-brand-sky/10" aria-hidden="true" />
        <div className="absolute left-0 top-1/2 h-px w-1/4 bg-gradient-to-r from-transparent to-brand-sky/50" aria-hidden="true" />

        <Container size="xl" className="relative">
          <div className="mb-8 flex items-center gap-3 text-xs font-bold uppercase tracking-[0.18em] text-brand-sky-light">
            <Waves className="h-5 w-5" aria-hidden="true" />
            The people behind the kit
          </div>
          <div className="grid items-end gap-10 lg:grid-cols-[minmax(0,1.55fr)_minmax(18rem,.65fr)]">
            <h1 className="max-w-5xl text-5xl font-bold leading-[0.98] tracking-[-0.055em] sm:text-6xl md:text-7xl lg:text-[5.5rem]">
              Medicine at sea, led by people who know the water.
            </h1>
            <p className="max-w-xl border-l border-brand-sky/40 pl-6 text-base leading-7 text-sky-100/75 md:text-lg">
              We are seafarers, medics, and maritime operators building practical medical support for life offshore.
            </p>
          </div>
          <div className="mt-16 h-px bg-white/10 md:mt-24" aria-hidden="true">
            <span className="block h-px w-1/5 translate-x-[120%] bg-brand-sky shadow-[0_0_18px_rgba(72,202,228,.7)]" />
          </div>
        </Container>
      </section>

      <section className="py-20 md:py-28" aria-labelledby="team-heading">
        <Container size="xl">
          <div className="mb-12 grid gap-6 lg:mb-16 lg:grid-cols-[.6fr_1.25fr_.85fr] lg:gap-10">
            <p className="pt-2 text-xs font-bold uppercase tracking-[0.18em] text-brand-ocean">
              Meet the crew
            </p>
            <h2 id="team-heading" className="text-4xl font-bold leading-[1.05] tracking-[-0.045em] text-brand-navy md:text-5xl">
              Experience that crosses disciplines.
            </h2>
            <p className="max-w-lg text-base leading-7 text-brand-gray">
              Maritime operations and emergency medicine belong in the same conversation. Our team lives in both worlds.
            </p>
          </div>
          <TeamGrid />
        </Container>
      </section>

      <section className="relative bg-brand-navy py-20 text-white md:py-28" aria-labelledby="values-heading">
        <div className="absolute inset-y-0 right-0 w-1/3 bg-gradient-to-l from-brand-blue/40 to-transparent" aria-hidden="true" />
        <Container size="xl" className="relative">
          <div className="mb-14 flex flex-col justify-between gap-6 md:flex-row md:items-end">
            <div>
              <p className="mb-4 text-xs font-bold uppercase tracking-[0.18em] text-brand-sky-light">How we work</p>
              <h2 id="values-heading" className="max-w-2xl text-4xl font-bold tracking-[-0.04em] md:text-5xl">
                Calm decisions. Clear standards.
              </h2>
            </div>
            <p className="max-w-sm text-sm leading-6 text-sky-100/65">
              The principles that guide what we recommend, how we communicate, and what we put aboard.
            </p>
          </div>

          <div className="grid border-y border-white/10 md:grid-cols-3">
            {values.map(({ number, icon: Icon, title, description }) => (
              <article key={title} className="border-b border-white/10 py-9 last:border-b-0 md:border-b-0 md:border-r md:px-8 md:first:pl-0 md:last:border-r-0 md:last:pr-0">
                <div className="mb-9 flex items-center justify-between">
                  <span className="text-xs font-bold tracking-[0.18em] text-brand-sky-light">{number}</span>
                  <Icon className="h-6 w-6 text-brand-sky" aria-hidden="true" />
                </div>
                <h3 className="mb-4 text-2xl font-bold tracking-tight">{title}</h3>
                <p className="text-sm leading-6 text-sky-100/65">{description}</p>
              </article>
            ))}
          </div>
        </Container>
      </section>

      <section className="bg-surface-secondary py-20 md:py-28">
        <Container size="xl">
          <div className="grid overflow-hidden rounded-[2rem] bg-white shadow-[0_24px_70px_rgba(15,45,70,.08)] lg:grid-cols-[1.35fr_.65fr]">
            <div className="p-8 md:p-14 lg:p-16">
              <p className="mb-4 text-xs font-bold uppercase tracking-[0.18em] text-brand-ocean">Work with us</p>
              <h2 className="max-w-2xl text-4xl font-bold leading-tight tracking-[-0.045em] text-brand-navy md:text-5xl">
                Bring your expertise aboard.
              </h2>
              <p className="mt-5 max-w-xl text-base leading-7 text-brand-gray">
                We are always glad to meet people who care about better medical support offshore. Tell us what you do and where you think you can help.
              </p>
            </div>
            <div className="flex items-end bg-gradient-to-br from-brand-ocean to-brand-blue p-8 text-white md:p-12">
              <a
                href="mailto:bluecross@marsoft.ai?subject=Working%20with%20BlueCross%20Medical"
                className="group flex min-h-14 w-full items-center justify-between rounded-full border border-white/30 px-6 font-semibold hover:bg-white hover:text-brand-navy"
              >
                Tell us about yourself
                <ArrowRight className="h-5 w-5 transition-transform group-hover:translate-x-1" aria-hidden="true" />
              </a>
            </div>
          </div>
        </Container>
      </section>
    </main>
  );
}

export default Team;
