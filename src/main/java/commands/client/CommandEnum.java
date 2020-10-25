package commands.client;

import commands.*;

public enum CommandEnum {
	TOINDEX {
			{
				this.command = new ToIndexCommand();
			}
	},
	LOGIN {
			{
				this.command = new LoginCommand();
			}
	},
	LOGOUT {
			{
				this.command = new LogoutCommand();
			}
	},
	TOLOGINFORM {
			{
				this.command = new ToLoginFormCommand();
			}
	},
	REGISTER {
			{
				this.command = new RegisterCommand();
			}
	},
	NOTREGISTER {
		{
			this.command = new NotRegisterCommand();
		}
	},
	TOREGISTERFORM {
			{
				this.command = new ToRegisterFormCommand();
			}
	},
	NEWORDER {
			{
				this.command = new NewOrderCommand();
			}
	},
	CREATEORDER {
			{
				this.command = new CreateOrderCommand();
			}
	},
	SHOWBILL {
			{
				this.command = new ShowBillCommand();
			}
	},
	BIDSCOMMAND {
			{
				this.command = new BidsCommand();
			}
	},
	ORDERREVIEW {
			{
				this.command = new OrderReviewCommand();
			}
	},
	CREATEBILL {
			{
				this.command = new CreateBillCommand();
			}
	},
	PAYBILL {
			{
				this.command = new PayBillCommand();
			}
	},
	SORTBIDS {
			{
				this.command = new SortBidsCommand();
			}
	},
	SORTORDERS {
			{
				this.command = new SortOrdersCommand();
			}
	};
		ActionCommand command;
		public ActionCommand getCurrentCommand() {
		return command;
		}
}
