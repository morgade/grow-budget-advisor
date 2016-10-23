import React from 'react';
import { connect, dispatch } from 'react-redux'

import ListGroupItem from 'react-bootstrap/lib/ListGroupItem';

class Item extends React.Component {

    render() {
        return (
            <ListGroupItem header={this.props.item.text}>
                {this.props.item.category.text}
                <span className="pull-right">
                    ${this.props.item.amount}
                </span>
            </ListGroupItem>
        );
    }

};

export default connect( state => ({ budget: state.budget }))(Item);
