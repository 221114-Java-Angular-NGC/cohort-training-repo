import { TestBed } from '@angular/core/testing';

import { SessionGuardGuard } from './session-guard.guard';

describe('SessionGuardGuard', () => {
  let guard: SessionGuardGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(SessionGuardGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
