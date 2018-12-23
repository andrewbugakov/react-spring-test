import React,{Component} from 'react';
import { FormGroup,FormControl,ControlLabel, Col} from 'react-bootstrap'

export default class FormInputElement extends Component {
    render(){
        return(
            <>
                <FormGroup controlId="formHorizontalName">
                    <Col componentClass={ControlLabel} sm={2}>
                        {this.props.label}
                    </Col>
                    <Col sm={10}>
                        <FormControl type={this.props.type?this.props.type:"text"} required={true} placeholder="Название" 
                        value={this.props.name} onChange={(event)=>this.props.onChange(event)}/>
                    </Col>
                </FormGroup>
                
            </>
        );
    }
}