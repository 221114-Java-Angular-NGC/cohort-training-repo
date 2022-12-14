import { TestBed } from '@angular/core/testing';

import { PlanetGeneratorService } from './planet-generator.service';

describe('PlanetGeneratorService', () => {
  let service: PlanetGeneratorService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PlanetGeneratorService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
