import React, {Component} from 'react';
import ItemTable from './ItemTable';
import Form from './Form';
import {API} from './const';

class ItemData extends Component {
  constructor(props) {
      super(props);
//      this.deleteItem = this.deleteItem.bind(this);
      this.createItem = this.createItem.bind(this);
      this.deleteItem = this.deleteItem.bind(this);
      this.state = {
          items: [],
      };
   }
 
  componentDidMount() {
    this.loadItemsFromServer();
  }
  
  // Load items from database
  loadItemsFromServer() {
	    fetch(API+ "items")
	      .then(response => response.json())
	      .then((items) => this.setState({items:items}));
	  }     
  
  // Create new item
  createItem(item) {
      fetch(API + "item", {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify(item)
      })
      .then( 
          res => this.loadItemsFromServer()
      )
      .catch( err => console.error(err))
  }
  
  deleteItem(item){
	  fetch(API + "item/" + item.id,
			  {method: 'DELETE',})
			  .then(res => this.loadItemsFromServer())
			  .catch(err => console.error(err))
  }
  
  render() {
    return (
       <div>
          <Form createItem={this.createItem}/>
          <ItemTable items={this.state.items}
                 deleteItem={this.deleteItem}/> 
          		 
       </div>
    );
  }
}
export default ItemData;