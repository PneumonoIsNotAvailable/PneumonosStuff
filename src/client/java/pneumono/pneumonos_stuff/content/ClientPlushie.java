package pneumono.pneumonos_stuff.content;

import pneumono.pneumonos_stuff.PneumonosStuffClient;
import pneumono.pneumonos_stuff.content.models.PlushieTransformation;

public record ClientPlushie(PlushieTransformation transformation, PneumonosStuffClient.FinishedModelContainerFunction container) {
}
