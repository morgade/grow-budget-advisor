// 3rd party modules
import React from 'react';
import { connect, dispatch } from 'react-redux'
import Row from 'react-bootstrap/lib/Row';
import Col from 'react-bootstrap/lib/Col';
import Alert from 'react-bootstrap/lib/Alert';


/**
 * A simple tip exibition component
 */
export default class Tip extends React.Component {
    /**
     *  TODO: use some solution to proccess marked up text from the tip service
     *  and avoid the use of dangerouslySetInnerHTML
     */
    createMarkup() {
        return {__html: this.props.text};
    }
    /**
     * React render method
     */
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

