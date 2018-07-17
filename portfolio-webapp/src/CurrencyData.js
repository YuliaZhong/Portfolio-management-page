import React, {Component} from 'react';
import CurrencyList from './CurrencyList';
import API from './const';

class CurrencyData extends Component {
	 constructor(props) {
	        super(props);
	        this.state = {
	           currencies: [],
	        };
	        }


	 componentDidMount() {
		    fetch(API + 'currency')
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

