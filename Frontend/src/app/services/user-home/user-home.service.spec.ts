import { TestBed } from '@angular/core/testing';

import { UserHomeService } from './user-home.service';

describe('UserLoginService', () => {
  let service: UserHomeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UserHomeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
