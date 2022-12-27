import { TestBed } from '@angular/core/testing';

import { AjaxSessionService } from './ajax-session.service';

describe('AjaxSessionService', () => {
  let service: AjaxSessionService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AjaxSessionService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
