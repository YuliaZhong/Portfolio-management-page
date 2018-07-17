import React, {Component} from 'react';
import CurrencyData from './CurrencyData';
import DatePicker from 'react-datepicker';
import moment from 'moment';
 
import 'react-datepicker/dist/react-datepicker.css';
import './Form.css';


class Form extends Component {
	constructor(props) {
	    super(props);
	    this.state = {amount: '', wallet: '', date: moment(), currency: ''};
	    this.handleChange = this.handleChange.bind(this);
	    this.handleSubmit = this.handleSubmit.bind(this);
	    this.handleSelect = this.handleSelect.bind(this);
	    
	  }

	 handleChange(event) {
	        console.log("NAME: " + event.target.name + " VALUE: " + event.target.value)
	        this.setState(
	            {[event.target.name]: event.target.value}
	        );
	    }    

	 handleSubmit(event) {
	        event.preventDefault();
	        var newItem = {currency: this.state.currency, amount: this.state.amount, wallet: this.state.wallet, date: this.state.date};
	        this.props.createItem(newItem);        
	    }
	  handleSelect(date) {
		  console.log(date)
		    this.setState({
		      date: date
		    });
		  }
	  render() {
		    return (
		      <div className="panel panel-default">
		      <div className="panel-heading"><h4>Add new item</h4></div>
		          <div className="panel-body">
		          <div className="form-group">
		        <div>
		        <label>Cryptocurrency <CurrencyData handleChange={this.handleChange}/></label>
		        </div>
		        <div>     
		        <label>Amount  <input type="text" placeholder="Amount" className="form-control"  
		                      name="amount" onChange={this.handleChange}/>  </label>  
		       </div>
		                  
		       <div>      
		       <label>Wallet location  <input type="text" placeholder="Wallet" className="form-control" 
		                      name="wallet" onChange={this.handleChange}/></label>
		       </div>     
		       <div>  
		       <label>Date of purchase <DatePicker selected={this.state.date}
		                    onChange={this.handleSelect} 
		                     dateFormat="DD/MM/YYYY" /></label>
		           
		                    	  </div> 
		          <div>
		         <button className="btn btn-success" onClick={this.handleSubmit}>Save</button>   
		           </div>
		          </div>
		          </div>      
		      </div>
		  );
		}
		}

export default Form;

