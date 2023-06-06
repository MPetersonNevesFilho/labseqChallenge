import "../styles/Signature.css"

export default function Signature() {

    return (
        <>
            <div className="signatureMain">
                <div className="signatureContainer">
                    <div className="signatureText">
                        <p className="signatureP">Made by Marcus Peterson</p>
                    </div>
                    <div className="signatureLinks">
                        <a href="https://www.linkedin.com/in/mpeterson-nevesfilho" target="_blank" rel="noreferrer"><i className="fab fa-linkedin"></i>
                            <img src="https://img.icons8.com/color/48/000000/linkedin.png" alt="LinkedIn" />
                        </a>
                        <a href="https://github.com/MPetersonNevesFilho" target="_blank" rel="noreferrer"><i className="fab fa-github"></i>
                            <img src="https://img.icons8.com/ios-filled/50/000000/github.png" alt="GitHub" className="gitImg" />
                        </a>
                    </div>
                </div>
            </div>
        </>
    )
}