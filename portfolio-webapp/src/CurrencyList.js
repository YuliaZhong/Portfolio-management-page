import React, {Component} from 'react';
import './CurrencyList.css';

class CurrencyList extends React.Component{

    constructor(props) {
        super(props);
        this.handler = this.handler.bind(this);
    }
    
    handler(event) {
		 this.props.handleChange(event);
	 }
    
    render() {
        var currencies = this.props.currencies.map(currency =>
            <option key={currency.id}> {currency.name}</option>
        );
        return (
        		  <div>
                  <select className="form-control" name ="currency" 
                  onChange={this.handler} >
                  <option selected>Select currency...</option>
                  {currencies} 
                  </select>
              </div>
             
           
          
        )
    }
}
export default CurrencyList;