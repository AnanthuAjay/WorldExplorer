import { TestBed } from '@angular/core/testing';

import { CountryApiDetailsService } from './country-api-details.service';

describe('CountryApiDetailsService', () => {
  let service: CountryApiDetailsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CountryApiDetailsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
