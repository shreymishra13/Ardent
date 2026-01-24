import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RefundPolicies } from './refund-policies';

describe('RefundPolicies', () => {
  let component: RefundPolicies;
  let fixture: ComponentFixture<RefundPolicies>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RefundPolicies]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RefundPolicies);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
