import React, {Component} from 'react';
import './ItemTable.css';

class ItemTable extends React.Component{

    constructor(props) {
        super(props);
    }
 
    render() {
        var items = this.props.items.map(item =>
            <Item key={item.id} item={item} deleteItem={this.props.deleteItem}/>
        );
        return (
            <table>
            <thead>
                <tr>
                <th>Cryptocurrency</th>
                    <th>Amount</th>
                    <th>Date of purchase</th>
                    <th>Wallet location</th>
                    <th>Curret market value (EUR)</th>
                </tr>
                </thead>
                <tbody>
                {items}
                </tbody>
            </table>
        )
    }
}


class Item extends React.Component{
	   constructor(props) {
	        super(props);
	        this.handleDelete = this.handleDelete.bind(this);
	    }
	   handleDelete(){
	    	this.props.deleteItem(this.props.item);
	    }
    render() {
        return (
            <tr>
               <td>{this.props.item.currency}</td>
                <td>{this.props.item.amount}</td>
                <td>{this.props.item.date}</td>
                <td>{this.props.item.wallet}</td>
                <td></td>
                <td><button className="btn btn-danger btn-xs" onClick={() => {if(window.confirm("Are you sure you want to delete this item?")){this.handleDelete()};}}>Delete</button></td>
            </tr>
        )
    }
}
export default ItemTable;