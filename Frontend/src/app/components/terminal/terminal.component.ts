import { Component, OnInit } from '@angular/core';
import { Terminal } from '../../shared/terminal';
import { HttpErrorResponse } from '@angular/common/http';
import { TerminalService } from 'src/app/services/terminal/terminal.service';

@Component({
  selector: 'app-terminal',
  templateUrl: './terminal.component.html',
  styleUrls: ['./terminal.component.css']
})
export class TerminalComponent implements OnInit {
  constructor(private service: TerminalService) { }

  terminal: Terminal = new Terminal(0, "", "", "", "", 0, "", "", 0);
  updateMessage: any;
  deleteMessage: any;
  errorMessage: any;
  showTerminal: any;
  deleteTerminal!: boolean;
  updateTerminal!: boolean;
  updateTerminalstatus!: boolean;
  fetchTerminalById!: boolean;
  fetchTerminalByType!: boolean;
  fetchFTRTerminals!: boolean;
  insertTerminal!: boolean;
  showInsertForm!: boolean;
  showInsertedDetails!: boolean;
  ShowFetchByIdDetails!: boolean;
  showFetchByTypeDetails!: boolean;

  ngOnInit(): void {
  }

  reset(): void {
    this.updateMessage = null;
    this.deleteMessage = null;
    this.errorMessage = null;
    this.showTerminal = null;
    this.deleteTerminal = false;
    this.updateTerminal = false;
    this.updateTerminalstatus = false;
    this.fetchFTRTerminals = false;
    this.fetchTerminalById = false;
    this.fetchTerminalByType = false;
    this.insertTerminal = false;
    this.showInsertForm = false;
    this.showInsertedDetails = false;
    this.showFetchByTypeDetails = false;
    this.ShowFetchByIdDetails = false;
  }

  public deleteIcon() {
    this.reset();
    this.deleteTerminal = true;
  }

  public updateIcon() {
    this.reset()
    this.updateTerminal = true;
  }

  public updateStatusIcon() {
    this.reset();
    this.updateTerminalstatus = true;
  }

  public fetchTerminalByIdIcon() {
    this.reset();
    this.fetchTerminalById = true;
  }

  public fetchTerminalByTypeIcon() {
    this.reset()
    this.fetchTerminalByType = true;
  }

  public insertTerminalIcon() {
    this.reset();
    this.insertTerminal = true;
    this.showInsertForm = true;
  }

  public deleteTerminalNow() {
    this.service.deleteTerminal(this.terminal.terminal_id).subscribe({
      next: (response: any) => {
        this.deleteMessage = response ?? '';
      },
      error: (error: HttpErrorResponse) => {
        this.errorMessage = error.message ?? '';
      }
    });
  }

  public updateTerminalNow() {
    this.service.updateTerminal(this.terminal.terminal_id, this.terminal.capacity).subscribe({
      next: (response: any) => {
        this.updateMessage = response ?? '';
      },
      error: (error: HttpErrorResponse) => {
        this.errorMessage = error.message ?? '';
      }
    });
  }

  public updateTerminalStatusNow() {
    this.service.updateTerminalStatus(this.terminal.terminal_id, this.terminal.status).subscribe({
      next: (response: any) => {
        this.updateMessage = response ?? '';
      },
      error: (error: HttpErrorResponse) => {
        this.errorMessage = error.message ?? '';
      }
    });
  }

  public fetchTerminalByIdNow() {
    this.ShowFetchByIdDetails = true;
    this.service.fetchTerminalById(this.terminal.terminal_id).subscribe({
      next: (response: any) => {
        this.showTerminal = response ?? '';
      },
      error: (error: HttpErrorResponse) => {
        console.log(error.message);
        this.errorMessage = error.message ?? '';
      }
    });
  }
  
  public fetchTerminalByTypeNow() {
    this.showFetchByTypeDetails = true;
    this.service.fetchTerminalByType(this.terminal.item_type).subscribe({
      next: (response: any) => {
        this.showTerminal = response ?? '';
      },
      error: (error: HttpErrorResponse) => {
        this.errorMessage = error.message ?? '';
      }
    });
  }

  public fetchFTRTerminalsNow() {
    this.reset();
    this.fetchFTRTerminals = true;
    this.service.fetchFTRTerminals().subscribe({
      next: (response: any) => {
        this.showTerminal = response ?? '';
      },
      error: (error: HttpErrorResponse) => {
        this.fetchFTRTerminals = false;
        this.errorMessage = error.message ?? '';
      }
    });
  }

  public insertTerminalNow() {
    this.showInsertForm = false;
    this.showInsertedDetails = true;
    this.service.insertTerminal(this.terminal).subscribe({
      next: (response: any) => {
        this.showTerminal = response ?? '';
      },
      error: (error: HttpErrorResponse) => {
        this.showInsertedDetails = false;
        this.errorMessage = error.message ?? '';
      }
    });
  }

  goBack() {
    window.history.back();
  }
}
