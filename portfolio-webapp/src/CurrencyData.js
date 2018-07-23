import React, {Component} from 'react';
import CurrencyList from './CurrencyList';
import {PRICE_API} from './const';

class CurrencyData extends Component {
	 constructor(props) {
	        super(props);
	        this.state = {
	           currencies: [],
	        };
	        }


	 componentDidMount() {
		    fetch(PRICE_API)
		      .then(response => response.json())
		      .then((currencies) => this.setState({currencies:currencies}));
		  }
	
	 
	 
	 render() {
	
		    return (
	    		<CurrencyList currencies={this.state.currencies} handleChange={this.props.handleChange}/>		
		    );
		  }
	    }
export default CurrencyData;

