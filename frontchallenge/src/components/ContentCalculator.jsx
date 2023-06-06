import { useState } from 'react'
import '../styles/ContentCalculator.css'
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';
import MessageMain from './MessageMain';
import Modal from 'react-bootstrap/Modal';
import 'bootstrap/dist/css/bootstrap.min.css';
import newPage from '../assets/imgs/newPage.svg'
import x from '../assets/imgs/x.png'

import { Labseq } from '../services/RequestApi.js'
import { RestartMemory } from '../services/RequestApi.js'

export default function Content () {
    const [show, setShow] = useState(false);
    const [search, setSearch] = useState(null)
    const [dataExist, setDataExist] = useState(null)
    const [jsonRequests, setJsonRequests] = useState([])
    const [lastRequest, setLastRequest] = useState("")
    const [requestTime, setRequestTime] = useState("Waiting for request...")

    const handleSubmit = (e) => {
        if (search === null) {
            alert("You must enter a number!");
        } else if (search > 15000) {
            alert("The number must be less than 15,000!");
        } else if (search < 0) {
            alert("The number must be greater than 0!");
        } if (search < 15000) {
            if (search === lastRequest) {
                alert("You already searched for this number!");
            } else {
                handleSearch();
                setLastRequest(search);
            }
        }
        e.preventDefault();
    }

    const handleSearch = async () => {

        let tempJson = jsonRequests;
        const tempDate = new Date().getTime();
        tempJson.unshift({
            n: search,
            data: await Labseq(search).then((response) => {return response.request.response})
        });
        setJsonRequests(tempJson);
        setRequestTime("Request time: " + (new Date().getTime() - tempDate) + "ms");

        dataExist? null : setDataExist(true);
        //handleFakeSearch();
    }

    const handleDelete = (n) => {
        let tempJson = jsonRequests;
        setJsonRequests(tempJson.filter((item) => item.n !== n));
        if (tempJson.length === 1) {
            setShow(false);
            setJsonRequests([]);
            setRequestTime("Waiting for request...");
            setDataExist(false);
            setSearch("");
        }
    }

    const handleFakeSearch = async () => {
        var tempDate = new Date().getTime();
        const tempJson = jsonRequests.concat(
            {
                n: Math.random() * 999,
                data: "3434534345345"
            }
        );
        setJsonRequests(tempJson);
        setRequestTime("Request time: " + (new Date().getTime() - tempDate) + "ms");
    }

    const handleRestart = () => {
        RestartMemory().then(() => {
            setShow(false);
            setJsonRequests([]);
            setRequestTime("Waiting for request...");
            setDataExist(false);
            setSearch("");
        }).catch((error) => {
            console.log(error);
        });
    }

    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);


    return (
        <>
            <div className="contentMain">
                <div className="contentContainer">
                    <div className="contentInput">
                        <Form className="d-flex">
                            <Form.Control
                            type="number"
                            placeholder="Less than 15,000"
                            className="me-2"
                            aria-label="Search"
                            onChange={(e) => setSearch(e.target.value)}
                            />
                            <Button variant="info" onClick={handleSubmit}>Search</Button>
                        </Form>
                    </div>
                    <div className="contentOutput">
                        <div className='contentData'>
                            <p>{requestTime}</p>
                        </div>
                        <div className='contentResponse'>
                            {
                                !dataExist?
                                <>
                                    <p className='contentResponseText' >Make your first request!</p>
                                    <img src={newPage} className='contentResponseImg' />
                                </>
                                :
                                <>
                                    {
                                        jsonRequests.map((item, index) => {
                                            return (
                                                <MessageMain key={index} n={item.n} numbers={item.data} deleteFunc={handleDelete}/>
                                            )
                                        })
                                    }
                                </>
                            }
                        </div>
                        {
                            !dataExist? null :
                            <div className='contentResposeRestart' onClick={handleShow}>
                                <p>Restart Memory</p>
                                <img src={x} alt='Restart memory' className='contentResposeRestartImg'/>
                            </div>

                        }
                    </div>
                </div>
            </div>
            <Modal show={show} onHide={handleClose} centered>
        <Modal.Header closeButton>
          <Modal.Title>Reset memory</Modal.Title>
        </Modal.Header>
        <Modal.Body>Are you sure you want to reset the memory?</Modal.Body>
        <Modal.Footer>
          <Button variant="danger" onClick={handleRestart}>
            Reset
          </Button>
          <Button variant="secondary" onClick={handleClose}>
            Close
          </Button>
        </Modal.Footer>
      </Modal>
        </>
    )
}