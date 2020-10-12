package commands.client;

import commands.ActionCommand;
import commands.CalculateShippingCostCommand;
import commands.LoginCommand;
import commands.LogoutCommand;
import commands.NotRegisterCommand;
import commands.RegisterCommand;
import commands.ToIndexCommand;
import commands.ToLoginFormCommand;
import commands.ToRegisterFormCommand;

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
	CALCULATESHIPPINGCOST {
			{
				this.command = new CalculateShippingCostCommand();
			}
	};
		ActionCommand command;
		public ActionCommand getCurrentCommand() {
		return command;
		}
}
