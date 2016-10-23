import React from 'react';
import { connect, dispatch } from 'react-redux'

import Row from 'react-bootstrap/lib/Row';
import Col from 'react-bootstrap/lib/Col';
import Alert from 'react-bootstrap/lib/Alert';



export default class Tip extends React.Component {
    /**
     *  TODO: use some solution to proccess marked up text from the tip service
     *  and avoid the use of dangerouslySetInnerHTML
     */
    createMarkup() {
        return {__html: this.props.text};
    }
    
    render() {
        return (
                <Col md={this.props.col}>
                    <Alert bsStyle={this.props.kind}>
                        <div dangerouslySetInnerHTML={this.createMarkup()} />
                    </Alert>
                </Col>
            )
    }
};

